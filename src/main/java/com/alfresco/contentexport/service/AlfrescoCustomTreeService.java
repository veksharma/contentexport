package com.alfresco.contentexport.service;

import com.alfresco.contentexport.dto.AlfrescoTreeNodeDto;
import com.alfresco.contentexport.dto.AlfrescoTreeResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlfrescoCustomTreeService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${alfresco.base-url}")
    private String alfrescoBaseUrl;

    @Value("${alfresco.username}")
    private String username;

    @Value("${alfresco.password}")
    private String password;

    public AlfrescoCustomTreeService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public AlfrescoTreeResponseDto getCompleteTree(String nodeId) {
        try {
            String url = UriComponentsBuilder
                    .fromHttpUrl(alfrescoBaseUrl)
                    .path("/alfresco/service/cchtax/nodes/")
                    .path(nodeId)
                    .path("/tree")
                    .build()
                    .toUriString();

            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(username, password);
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            return objectMapper.readValue(response.getBody(), AlfrescoTreeResponseDto.class);

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch Alfresco custom node tree for nodeId: " + nodeId, e);
        }
    }

    public AlfrescoTreeResponseDto getTreeByLevel(String nodeId, int level) {
        AlfrescoTreeResponseDto fullTree = getCompleteTree(nodeId);

        List<AlfrescoTreeNodeDto> filteredNodes = fullTree.getNodes()
                .stream()
                .filter(node -> node.getLevel() != null && node.getLevel() == level)
                .collect(Collectors.toList());

        AlfrescoTreeResponseDto response = new AlfrescoTreeResponseDto();
        response.setRootNodeId(fullTree.getRootNodeId());
        response.setTotalNodes(filteredNodes.size());
        response.setNodes(filteredNodes);

        return response;
    }

    public AlfrescoTreeResponseDto getTreePaged(String nodeId, int page, int size) {
        if (page < 0) {
            page = 0;
        }

        if (size < 1) {
            size = 50;
        }

        if (size > 500) {
            size = 500;
        }

        AlfrescoTreeResponseDto fullTree = getCompleteTree(nodeId);

        List<AlfrescoTreeNodeDto> allNodes = fullTree.getNodes();

        int total = allNodes == null ? 0 : allNodes.size();
        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, total);

        List<AlfrescoTreeNodeDto> pagedNodes;

        if (fromIndex >= total) {
            pagedNodes = List.of();
        } else {
            pagedNodes = allNodes.subList(fromIndex, toIndex);
        }

        AlfrescoTreeResponseDto response = new AlfrescoTreeResponseDto();
        response.setRootNodeId(fullTree.getRootNodeId());
        response.setTotalNodes(total);
        response.setNodes(pagedNodes);

        return response;
    }
}