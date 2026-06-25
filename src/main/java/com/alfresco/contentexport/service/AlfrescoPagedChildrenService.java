package com.alfresco.contentexport.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class AlfrescoPagedChildrenService {

    private final RestTemplate restTemplate;

    @Value("${alfresco.base-url}")
    private String alfrescoBaseUrl;

    @Value("${alfresco.username}")
    private String username;

    @Value("${alfresco.password}")
    private String password;

    public AlfrescoPagedChildrenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getPagedChildren(String folderNodeId, int page, int size) {
        if (page < 0) {
            page = 0;
        }

        if (size < 1) {
            size = 1000;
        }

        if (size > 1000) {
            size = 1000;
        }

        int skipCount = page * size;

        String url = UriComponentsBuilder
                .fromHttpUrl(alfrescoBaseUrl)
                .path("/alfresco/service/api/node/workspace/SpacesStore/")
                .path(folderNodeId)
                .path("/children")
                .queryParam("maxItems", size)
                .queryParam("skipCount", page)
                .build()
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        headers.setAccept(List.of(
                MediaType.APPLICATION_ATOM_XML,
                MediaType.APPLICATION_XML,
                MediaType.TEXT_XML,
                MediaType.ALL
        ));

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        return parseChildrenFeed(folderNodeId, page, size, skipCount, response.getBody());
    }

    private Map<String, Object> parseChildrenFeed(
            String folderNodeId,
            int page,
            int size,
            int skipCount,
            String xml
    ) {
        if (xml == null || xml.isBlank()) {
            Map<String, Object> empty = new LinkedHashMap<>();
            empty.put("folderNodeId", folderNodeId);
            empty.put("page", page);
            empty.put("size", size);
            empty.put("skipCount", skipCount);
            empty.put("totalResults", 0);
            empty.put("items", Collections.emptyList());
            return empty;
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(
                    new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))
            );

            document.getDocumentElement().normalize();

            int totalResults = getIntText(document, "http://a9.com/-/spec/opensearch/1.1/", "totalResults", 0);
            int startIndex = getIntText(document, "http://a9.com/-/spec/opensearch/1.1/", "startIndex", skipCount);
            int itemsPerPage = getIntText(document, "http://a9.com/-/spec/opensearch/1.1/", "itemsPerPage", size);
            int numItems = getIntText(document, "http://docs.oasis-open.org/ns/cmis/restatom/200908/", "numItems", totalResults);

            String nextUrl = getLinkHref(document, "next");
            boolean hasNext = nextUrl != null && !nextUrl.isBlank();

            List<Map<String, Object>> items = parseEntries(document);

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("folderNodeId", folderNodeId);
            result.put("page", page);
            result.put("size", size);
            result.put("skipCount", skipCount);
            result.put("totalResults", totalResults);
            result.put("numItems", numItems);
            result.put("startIndex", startIndex);
            result.put("itemsPerPage", itemsPerPage);
            result.put("itemsCount", items.size());
            result.put("hasPrevious", skipCount > 0);
            result.put("hasNext", hasNext);
            result.put("nextSkipCount", hasNext ? skipCount + size : null);
            result.put("previousSkipCount", skipCount > 0 ? Math.max(skipCount - size, 0) : null);
            result.put("nextPage", hasNext ? page + 1 : null);
            result.put("previousPage", page > 0 ? page - 1 : null);
            result.put("items", items);

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Alfresco children XML", e);
        }
    }

    private List<Map<String, Object>> parseEntries(Document document) {
        List<Map<String, Object>> items = new ArrayList<>();

        NodeList entries = document.getElementsByTagNameNS(
                "http://www.w3.org/2005/Atom",
                "entry"
        );

        for (int i = 0; i < entries.getLength(); i++) {
            Element entry = (Element) entries.item(i);
            Map<String, Object> item = parseEntry(entry);

            if (item.get("nodeId") != null) {
                items.add(item);
            }
        }

        return items;
    }

    private Map<String, Object> parseEntry(Element entry) {
        Map<String, Object> item = new LinkedHashMap<>();

        String atomId = getText(entry, "http://www.w3.org/2005/Atom", "id");
        String atomTitle = getText(entry, "http://www.w3.org/2005/Atom", "title");
        String published = getText(entry, "http://www.w3.org/2005/Atom", "published");
        String updated = getText(entry, "http://www.w3.org/2005/Atom", "updated");

        String contentSrc = getContentSrc(entry);

        Map<String, Object> properties = extractProperties(entry);

        String nodeRef = getString(properties, "cmis_objectId");
        String nodeId = extractNodeId(nodeRef);

        item.put("nodeId", nodeId);
        item.put("nodeRef", nodeRef);
        item.put("atomId", atomId);
        item.put("name", firstNonBlank(getString(properties, "cmis_name"), atomTitle));
        item.put("title", atomTitle);

        item.put("objectType", properties.get("cmis_objectTypeId"));
        item.put("baseType", properties.get("cmis_baseTypeId"));
        item.put("mimeType", properties.get("cmis_contentStreamMimeType"));
        item.put("size", properties.get("cmis_contentStreamLength"));
        item.put("version", properties.get("cmis_versionLabel"));

        item.put("createdBy", properties.get("cmis_createdBy"));
        item.put("lastModifiedBy", properties.get("cmis_lastModifiedBy"));
        item.put("creationDate", properties.get("cmis_creationDate"));
        item.put("lastModificationDate", properties.get("cmis_lastModificationDate"));
        item.put("published", published);
        item.put("updated", updated);

        // Custom notification fields from your XML
        item.put("subject", properties.get("sTaxNotification_subject"));
        item.put("citation", properties.get("sTaxNotification_citation"));
        item.put("docSummary", properties.get("sTaxNotification_docSummery"));
        item.put("sTaxNotificationDate", properties.get("sTaxNotification_sTaxNotificationDate"));
        item.put("pnID", properties.get("sTaxNotification_pnID"));
        item.put("intSortOrderNew", properties.get("sTaxNotification_intSortOrderNew"));
        item.put("contentState", properties.get("cch_contentState"));
        item.put("publishedDate", properties.get("cch_published"));
        item.put("cmTitle", properties.get("cm_title"));

        item.put("alfrescoContentSrc", contentSrc);

        if (nodeId != null) {
            item.put("contentUrl", "/api/v1/alfresco/nodes/" + nodeId + "/content");
            item.put("metadataUrl", "/api/v1/alfresco/nodes/" + nodeId + "/metadata-json");
            item.put("childrenUrl", "/api/v1/alfresco/folders/" + nodeId + "/children/paged?page=0&size=10");
        }

        return item;
    }

    private Map<String, Object> extractProperties(Element entry) {
        Map<String, Object> properties = new LinkedHashMap<>();

        NodeList allNodes = entry.getElementsByTagNameNS("*", "*");

        for (int i = 0; i < allNodes.getLength(); i++) {
            Node node = allNodes.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element element = (Element) node;
            String localName = element.getLocalName();

            if (localName == null || !localName.startsWith("property")) {
                continue;
            }

            String propertyName = element.getAttribute("propertyDefinitionId");

            if (propertyName == null || propertyName.isBlank()) {
                propertyName = element.getAttribute("queryName");
            }

            if (propertyName == null || propertyName.isBlank()) {
                continue;
            }

            String safeKey = normalizeKey(propertyName);
            List<String> values = getValues(element);

            if (values.isEmpty()) {
                properties.put(safeKey, null);
            } else if (values.size() == 1) {
                properties.put(safeKey, convertValue(values.get(0), localName));
            } else {
                properties.put(safeKey, values);
            }
        }

        return properties;
    }

    private String getContentSrc(Element entry) {
        NodeList contentNodes = entry.getElementsByTagNameNS(
                "http://www.w3.org/2005/Atom",
                "content"
        );

        if (contentNodes.getLength() == 0) {
            return null;
        }

        Element content = (Element) contentNodes.item(0);
        return content.getAttribute("src");
    }

    private String getLinkHref(Document document, String relValue) {
        NodeList links = document.getElementsByTagNameNS(
                "http://www.w3.org/2005/Atom",
                "link"
        );

        for (int i = 0; i < links.getLength(); i++) {
            Element link = (Element) links.item(i);

            String rel = link.getAttribute("rel");

            if (relValue.equals(rel)) {
                return link.getAttribute("href");
            }
        }

        return null;
    }

    private int getIntText(Document document, String namespace, String localName, int defaultValue) {
        String value = getText(document.getDocumentElement(), namespace, localName);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private String getText(Element parent, String namespace, String localName) {
        NodeList nodes = parent.getElementsByTagNameNS(namespace, localName);

        if (nodes.getLength() == 0) {
            return null;
        }

        return nodes.item(0).getTextContent();
    }

    private List<String> getValues(Element propertyElement) {
        List<String> values = new ArrayList<>();

        NodeList valueNodes = propertyElement.getElementsByTagNameNS("*", "value");

        for (int i = 0; i < valueNodes.getLength(); i++) {
            values.add(valueNodes.item(i).getTextContent());
        }

        return values;
    }

    private Object convertValue(String value, String propertyType) {
        if (value == null) {
            return null;
        }

        try {
            if ("propertyInteger".equals(propertyType)) {
                return Long.parseLong(value);
            }

            if ("propertyBoolean".equals(propertyType)) {
                return Boolean.parseBoolean(value);
            }

            if ("propertyDecimal".equals(propertyType)) {
                return Double.parseDouble(value);
            }

            return value;
        } catch (Exception e) {
            return value;
        }
    }

    private String normalizeKey(String key) {
        if (key == null) {
            return null;
        }

        return key
                .replace(":", "_")
                .replace("-", "_")
                .replace(".", "_")
                .replace(" ", "_");
    }

    private String extractNodeId(String nodeRef) {
        if (nodeRef == null || nodeRef.isBlank()) {
            return null;
        }

        if (nodeRef.startsWith("workspace://SpacesStore/")) {
            return nodeRef.substring(nodeRef.lastIndexOf("/") + 1);
        }

        if (nodeRef.startsWith("urn:uuid:")) {
            return nodeRef.substring("urn:uuid:".length());
        }

        return nodeRef;
    }

    private String getString(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value == null ? null : String.valueOf(value);
    }

    private String firstNonBlank(String first, String second) {
        if (first != null && !first.isBlank()) {
            return first;
        }

        return second;
    }
}