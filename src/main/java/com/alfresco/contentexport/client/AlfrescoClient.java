package com.alfresco.contentexport.client;

import com.alfresco.contentexport.config.AlfrescoProperties;
import com.alfresco.contentexport.dto.DocListResponse;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

@Component
public class AlfrescoClient {

    private static final Logger log = LoggerFactory.getLogger(AlfrescoClient.class);

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
        log.info("Fetching node metadata for nodeId={}", nodeId);
        String url = properties.getBaseUrl()
                + "/alfresco/service/api/node/workspace/SpacesStore/"
                + nodeId;
        log.debug("Alfresco request URL: {}", url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        log.info("Fetched node metadata for nodeId={}, status={}", nodeId, response.getStatusCode());
        return response;
    }

    public ResponseEntity<byte[]> getNodeContent(String nodeId) {
        log.info("Fetching node content for nodeId={}", nodeId);
        String url = properties.getBaseUrl()
                + "/alfresco/service/api/node/content/workspace/SpacesStore/"
                + nodeId;
        log.debug("Alfresco request URL: {}", url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<byte[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                byte[].class
        );
        int bytes = response.getBody() != null ? response.getBody().length : 0;
        log.info("Fetched node content for nodeId={}, status={}, bytes={}", nodeId, response.getStatusCode(), bytes);
        return response;
    }

    public ResponseEntity<String> search(String keyword) {
        log.info("Searching Alfresco for keyword={}", keyword);
        String encodedKeyword = UriUtils.encode(keyword, StandardCharsets.UTF_8);

        String url = properties.getBaseUrl()
                + "/alfresco/service/api/search/keyword.json?q="
                + encodedKeyword;
        log.debug("Alfresco request URL: {}", url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        log.info("Search completed for keyword={}, status={}", keyword, response.getStatusCode());
        return response;
    }

    public ResponseEntity<String> getSites() {
        log.info("Fetching Alfresco sites");
        String url = properties.getBaseUrl()
                + "/alfresco/service/api/sites";
        log.debug("Alfresco request URL: {}", url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        log.info("Fetched Alfresco sites, status={}", response.getStatusCode());
        return response;
    }

    public ResponseEntity<String> getSiteDocumentLibrary(String siteShortName) {
        log.info("Fetching document library for site={}", siteShortName);
        String url = properties.getBaseUrl()
                + "/alfresco/service/slingshot/doclib/doclist/all/site/"
                + siteShortName
                + "/documentLibrary";
        log.debug("Alfresco request URL: {}", url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        log.info("Fetched document library for site={}, status={}", siteShortName, response.getStatusCode());
        return response;
    }

    public ResponseEntity<String> getFolderChildren(String folderNodeId) {
        log.info("Fetching folder children for folderNodeId={}", folderNodeId);
        String url = properties.getBaseUrl()
                + "/alfresco/service/slingshot/doclib/doclist/all/node/workspace/SpacesStore/"
                + folderNodeId;
        log.debug("Alfresco request URL: {}", url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        log.info("Fetched folder children for folderNodeId={}, status={}", folderNodeId, response.getStatusCode());
        return response;
    }

    public ResponseEntity<DocListShortResponse> getFolderChildrenAsDocList(String folderNodeId) {
        log.info("Fetching folder doc list for folderNodeId={}", folderNodeId);
        String url = properties.getBaseUrl()
                + "/alfresco/service/slingshot/doclib/doclist/all/node/workspace/SpacesStore/"
                + folderNodeId;
        log.debug("Alfresco request URL: {}", url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<DocListShortResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                DocListShortResponse.class
        );
        DocListShortResponse body = response.getBody();
        int totalRecords = body != null ? body.getTotalRecords() : 0;
        int itemCount = body != null && body.getItems() != null ? body.getItems().size() : 0;
        log.info(
                "Fetched folder doc list for folderNodeId={}, status={}, totalRecords={}, items={}",
                folderNodeId,
                response.getStatusCode(),
                totalRecords,
                itemCount
        );
        return response;
    }




    public ResponseEntity<DocListShortResponse> getFolderChildrenAsDocListWithPagination(
            String folderNodeId,
            int page,
            int size) {

        log.info("Fetching paginated folder doc list for folderNodeId={}", folderNodeId);

        int skipCount = (page - 1) * size;

        String url = properties.getBaseUrl()
                + "/alfresco/service/slingshot/doclib/doclist/all/node/workspace/SpacesStore/"
                + folderNodeId
                + "?skipCount=" + skipCount
                + "&maxItems=" + size;

        System.out.println("URL = " + url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<DocListShortResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                DocListShortResponse.class
        );

        // Manual Pagination
        DocListShortResponse body = response.getBody();

        if (body != null && body.getItems() != null) {

            int start = (page - 1) * size;
            int end = Math.min(start + size, body.getItems().size());

            if (start < body.getItems().size()) {
                body.setItems(body.getItems().subList(start, end));
            } else {
                body.setItems(java.util.Collections.emptyList());
            }
        }

        return ResponseEntity.status(response.getStatusCode()).body(body);
    }










    public ResponseEntity<DocListResponse> getFolderChildrenList(String folderNodeId) {
        log.info("Fetching folder doc list for folderNodeId={}", folderNodeId);
        String url = properties.getBaseUrl()
                + "/alfresco/service/slingshot/doclib/doclist/all/node/workspace/SpacesStore/"
                + folderNodeId;
        log.debug("Alfresco request URL: {}", url);

        HttpEntity<Void> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<DocListResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                DocListResponse.class
        );
        DocListResponse body = response.getBody();
        int totalRecords = body != null ? body.getTotalRecords() : 0;
        int itemCount = body != null && body.getItems() != null ? body.getItems().size() : 0;
        log.info(
                "Fetched folder doc list for folderNodeId={}, status={}, totalRecords={}, items={}",
                folderNodeId,
                response.getStatusCode(),
                totalRecords,
                itemCount
        );
        return response;
    }
}