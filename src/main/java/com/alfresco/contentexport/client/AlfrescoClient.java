package com.alfresco.contentexport.client;

import com.alfresco.contentexport.dto.AlfrescoChildrenResponse;
import com.alfresco.contentexport.dto.AlfrescoNode;
import com.alfresco.contentexport.dto.AlfrescoNodeEntry;
import com.alfresco.contentexport.dto.AlfrescoNodeResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AlfrescoClient {

    private final WebClient webClient;

    public AlfrescoClient(WebClient alfrescoWebClient) {
        this.webClient = alfrescoWebClient;
    }

    public AlfrescoChildrenResponse getChildren(String folderId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{folderId}/children")
                        .queryParam("include", "path,properties")
                        .build(folderId))
                .retrieve()
                .bodyToMono(AlfrescoChildrenResponse.class)
                .block();
    }

    public AlfrescoNode getNode(String nodeId) {
        AlfrescoNodeResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{nodeId}")
                        .queryParam("include", "path,properties")
                        .build(nodeId))
                .retrieve()
                .bodyToMono(AlfrescoNodeResponse.class)
                .block();

        return response.getEntry();
    }

    public Resource downloadContent(String nodeId) {
        return webClient.get()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{nodeId}/content", nodeId)
                .retrieve()
                .bodyToMono(Resource.class)
                .block();
    }

    public String downloadTextContent(String nodeId) {
        return webClient.get()
                .uri("/alfresco/api/-default-/public/alfresco/versions/1/nodes/{nodeId}/content", nodeId)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}