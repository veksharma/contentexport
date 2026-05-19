package com.alfresco.contentexport.client;

import com.alfresco.contentexport.config.AlfrescoProperties;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

@Component
public class AlfrescoClient {

    private final RestTemplate restTemplate;
    private final AlfrescoProperties properties;

    public AlfrescoClient(RestTemplate restTemplate, AlfrescoProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(properties.getUsername(), properties.getPassword());
        headers.setAccept(MediaType.parseMediaTypes("application/json,text/html,text/plain,*/*"));
        return headers;
    }

    public ResponseEntity<String> getNodeMetadata(String nodeId) {
        String url = properties.getBaseUrl()
                + "/alfresco/service/api/node/workspace/SpacesStore/"
                + nodeId;

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
    }

    public ResponseEntity<byte[]> getNodeContent(String nodeId) {
        String url = properties.getBaseUrl()
                + "/alfresco/service/api/node/content/workspace/SpacesStore/"
                + nodeId;

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                byte[].class
        );
    }

    public ResponseEntity<String> search(String keyword) {
        String encodedKeyword = UriUtils.encode(keyword, StandardCharsets.UTF_8);

        String url = properties.getBaseUrl()
                + "/alfresco/service/api/search/keyword.json?q="
                + encodedKeyword;

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
    }

    public ResponseEntity<String> getSites() {
        String url = properties.getBaseUrl()
                + "/alfresco/service/api/sites";

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
    }

    public ResponseEntity<String> getSiteDocumentLibrary(String siteShortName) {
        String url = properties.getBaseUrl()
                + "/alfresco/service/slingshot/doclib/doclist/all/site/"
                + siteShortName
                + "/documentLibrary";

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
    }

    public ResponseEntity<String> getFolderChildren(String folderNodeId) {
        String url = properties.getBaseUrl()
                + "/alfresco/service/slingshot/doclib/doclist/all/node/workspace/SpacesStore/"
                + folderNodeId;

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
    }

    public ResponseEntity<DocListShortResponse> getFolderChildrenAsDocList(String folderNodeId) {
        String url = properties.getBaseUrl()
                + "/alfresco/service/slingshot/doclib/doclist/all/node/workspace/SpacesStore/"
                + folderNodeId;

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                DocListShortResponse.class
        );
    }
}