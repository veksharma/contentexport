package com.alfresco.contentexport.controller;


import com.alfresco.contentexport.service.AlfrescoMetadataService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class MetadataController {

    private final AlfrescoMetadataService alfrescoMetadataService;

    public MetadataController(AlfrescoMetadataService alfrescoMetadataService) {
        this.alfrescoMetadataService = alfrescoMetadataService;
    }

    /**
     * Converts Alfresco XML metadata response into JSON.
     * <p>
     * Example:
     * GET /api/v1/alfresco/nodes/07c6038f-e154-4836-9609-e7ae85300582/metadata-json
     */
    @GetMapping(
            value = "/metadata/{nodeId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> getNodeMetadataAsJson(@PathVariable String nodeId) {
        Map<String, Object> response = alfrescoMetadataService.getNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }
}