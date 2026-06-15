package com.alfresco.contentexport.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class AlfrescoPagedDoclibService {

    private final RestTemplate restTemplate;

    @Value("${alfresco.base-url}")
    private String alfrescoBaseUrl;

    @Value("${alfresco.username}")
    private String username;

    @Value("${alfresco.password}")
    private String password;

    public AlfrescoPagedDoclibService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPagedChildren(String folderNodeId, int page, int size) {
        if (page < 0) {
            page = 0;
        }

        if (size < 1) {
            size = 100;
        }

        if (size > 500) {
            size = 500;
        }

        int skip = page * size;
        int max = size;

        String url = UriComponentsBuilder
                .fromHttpUrl(alfrescoBaseUrl)
                .path("/alfresco/service/slingshot/doclib/doclist/all/node/workspace/SpacesStore/")
                .path(folderNodeId)
                .queryParam("max", max)
                .queryParam("skip", skip)
                .build()
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON, MediaType.ALL));

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}