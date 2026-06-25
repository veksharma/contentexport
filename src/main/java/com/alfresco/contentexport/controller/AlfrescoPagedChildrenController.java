package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.service.AlfrescoPagedChildrenService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/alfresco")
public class AlfrescoPagedChildrenController {

    private final AlfrescoPagedChildrenService alfrescoPagedChildrenService;

    public AlfrescoPagedChildrenController(AlfrescoPagedChildrenService alfrescoPagedChildrenService) {
        this.alfrescoPagedChildrenService = alfrescoPagedChildrenService;
    }

    @GetMapping(
            value = "/folders/{folderNodeId}/children/paged",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> getPagedChildren(
            @PathVariable String folderNodeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1000") int size
    ) {
        return ResponseEntity.ok(
                alfrescoPagedChildrenService.getPagedChildren(folderNodeId, page, size)
        );
    }
}