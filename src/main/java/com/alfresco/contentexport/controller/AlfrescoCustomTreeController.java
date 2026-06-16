package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.dto.AlfrescoTreeResponseDto;
import com.alfresco.contentexport.service.AlfrescoCustomTreeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/alfresco/custom")
public class AlfrescoCustomTreeController {

    private final AlfrescoCustomTreeService alfrescoCustomTreeService;

    public AlfrescoCustomTreeController(AlfrescoCustomTreeService alfrescoCustomTreeService) {
        this.alfrescoCustomTreeService = alfrescoCustomTreeService;
    }

    @GetMapping(
            value = "/nodes/{nodeId}/tree",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AlfrescoTreeResponseDto> getCompleteTree(@PathVariable String nodeId) {
        return ResponseEntity.ok(alfrescoCustomTreeService.getCompleteTree(nodeId));
    }

    @GetMapping(
            value = "/nodes/{nodeId}/tree/level/{level}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AlfrescoTreeResponseDto> getTreeByLevel(
            @PathVariable String nodeId,
            @PathVariable int level
    ) {
        return ResponseEntity.ok(alfrescoCustomTreeService.getTreeByLevel(nodeId, level));
    }

    @GetMapping(
            value = "/nodes/{nodeId}/tree/paged",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AlfrescoTreeResponseDto> getTreePaged(
            @PathVariable String nodeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        return ResponseEntity.ok(alfrescoCustomTreeService.getTreePaged(nodeId, page, size));
    }
}