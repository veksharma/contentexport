package com.alfresco.contentexport.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlfrescoMetadataService {

    private final RestTemplate restTemplate;

    @Value("${alfresco.base-url}")
    private String alfrescoBaseUrl;

    @Value("${alfresco.username}")
    private String alfrescoUsername;

    @Value("${alfresco.password}")
    private String alfrescoPassword;

    private static final Logger log = LoggerFactory.getLogger(AlfrescoMetadataService.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public AlfrescoMetadataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> fullMetadata(String nodeId) {
        log.info("Fetching fullMetadata for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return stringObjectMap;
    }

    public String getNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessMetaData(stringObjectMap, nodeId);
    }

    private String getLessMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("nodeId", nodeId);
            response.put("subject", properties.get("sTaxNotification:subject"));
            response.put("sTaxNotificationDate", properties.get("sTaxNotification:sTaxNotificationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch notification summary"
                }
                """;
        }
    }

    private String fetchAlfrescoNodeMetadataXml(String nodeId) {
        String url = alfrescoBaseUrl
                + "/alfresco/service/api/node/workspace/SpacesStore/"
                + nodeId;

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(alfrescoUsername, alfrescoPassword);
        headers.setAccept(List.of(MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.ALL));

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class
        );

        return response.getBody();
    }

    private Map<String, Object> convertAlfrescoXmlToJson(String nodeId, String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(
                    new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))
            );

            document.getDocumentElement().normalize();

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("nodeId", nodeId);
            result.put("nodeRef", "workspace://SpacesStore/" + nodeId);

            // Atom basic fields
            result.put("id", getTextByLocalName(document, "id"));
            result.put("title", getTextByLocalName(document, "title"));
            result.put("summary", getTextByLocalName(document, "summary"));
            result.put("published", getTextByLocalName(document, "published"));
            result.put("updated", getTextByLocalName(document, "updated"));
            result.put("author", getAuthorName(document));

            // Content URL
            Element contentElement = getFirstElementByLocalName(document, "content");
            if (contentElement != null) {
                result.put("contentType", contentElement.getAttribute("type"));
                result.put("contentUrl", contentElement.getAttribute("src"));
            }

            // CMIS properties
            Map<String, Object> properties = extractCmisProperties(document);
            result.put("properties", properties);

            // Custom properties only
            Map<String, Object> customProperties = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                if (entry.getKey().contains(":")
                        && !entry.getKey().startsWith("cmis:")
                        && !entry.getKey().startsWith("cm:")
                        && !entry.getKey().startsWith("alfcmis:")
                        && !entry.getKey().startsWith("app:")
                        && !entry.getKey().startsWith("cch:")) {
                    customProperties.put(entry.getKey(), entry.getValue());
                }
            }
            result.put("customProperties", customProperties);

            // Alfresco aspects
            result.put("aspects", extractAspects(document));

            // Useful direct fields
            result.put("name", properties.get("cmis:name"));
            result.put("objectType", properties.get("cmis:objectTypeId"));
            result.put("baseType", properties.get("cmis:baseTypeId"));
            result.put("createdBy", properties.get("cmis:createdBy"));
            result.put("lastModifiedBy", properties.get("cmis:lastModifiedBy"));
            result.put("creationDate", properties.get("cmis:creationDate"));
            result.put("lastModificationDate", properties.get("cmis:lastModificationDate"));
            result.put("mimeType", properties.get("cmis:contentStreamMimeType"));
            result.put("size", properties.get("cmis:contentStreamLength"));
            result.put("version", properties.get("cmis:versionLabel"));

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Alfresco XML metadata to JSON", e);
        }
    }

    private Map<String, Object> extractCmisProperties(Document document) {
        Map<String, Object> properties = new LinkedHashMap<>();

        NodeList allNodes = document.getElementsByTagNameNS("*", "*");

        for (int i = 0; i < allNodes.getLength(); i++) {
            Node node = allNodes.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element element = (Element) node;
            String localName = element.getLocalName();

            if (localName != null && localName.startsWith("property")) {
                String propertyName = element.getAttribute("propertyDefinitionId");

                if (propertyName == null || propertyName.isBlank()) {
                    propertyName = element.getAttribute("queryName");
                }

                if (propertyName == null || propertyName.isBlank()) {
                    continue;
                }

                List<String> values = getChildValues(element);

                if (values.isEmpty()) {
                    properties.put(propertyName, null);
                } else if (values.size() == 1) {
                    properties.put(propertyName, convertValue(values.get(0), localName));
                } else {
                    properties.put(propertyName, values);
                }
            }
        }

        return properties;
    }

    private List<String> getChildValues(Element propertyElement) {
        List<String> values = new ArrayList<>();

        NodeList children = propertyElement.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            if (child.getNodeType() == Node.ELEMENT_NODE
                    && "value".equals(child.getLocalName())) {
                values.add(child.getTextContent());
            }
        }

        return values;
    }

    private Object convertValue(String value, String propertyType) {
        if (value == null) {
            return null;
        }

        if (propertyType == null) {
            return value;
        }

        try {
            if (propertyType.equals("propertyInteger")) {
                return Long.parseLong(value);
            }

            if (propertyType.equals("propertyBoolean")) {
                return Boolean.parseBoolean(value);
            }

            if (propertyType.equals("propertyDecimal")) {
                return Double.parseDouble(value);
            }

            // Keep date-time as string to avoid timezone conversion issues
            if (propertyType.equals("propertyDateTime")) {
                return value;
            }

            return value;

        } catch (Exception ex) {
            return value;
        }
    }

    private List<String> extractAspects(Document document) {
        List<String> aspects = new ArrayList<>();

        NodeList nodes = document.getElementsByTagNameNS("*", "appliedAspects");

        for (int i = 0; i < nodes.getLength(); i++) {
            String aspect = nodes.item(i).getTextContent();

            if (aspect != null && !aspect.isBlank()) {
                aspects.add(aspect);
            }
        }

        return aspects;
    }

    private String getTextByLocalName(Document document, String localName) {
        NodeList nodes = document.getElementsByTagNameNS("*", localName);

        if (nodes.getLength() == 0) {
            return null;
        }

        return nodes.item(0).getTextContent();
    }

    private Element getFirstElementByLocalName(Document document, String localName) {
        NodeList nodes = document.getElementsByTagNameNS("*", localName);

        if (nodes.getLength() == 0) {
            return null;
        }

        return (Element) nodes.item(0);
    }

    private String getAuthorName(Document document) {
        NodeList authors = document.getElementsByTagNameNS("*", "author");

        if (authors.getLength() == 0) {
            return null;
        }

        Element author = (Element) authors.item(0);
        NodeList names = author.getElementsByTagNameNS("*", "name");

        if (names.getLength() == 0) {
            return null;
        }

        return names.item(0).getTextContent();
    }
}