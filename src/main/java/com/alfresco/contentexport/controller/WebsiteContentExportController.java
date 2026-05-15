package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.dto.WebsiteContentExportResponse;
import com.alfresco.contentexport.dto.WebsiteContentItemDto;
import com.alfresco.contentexport.service.WebsiteContentExportService;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/website-content")
public class WebsiteContentExportController {

    private final WebsiteContentExportService exportService;

    public WebsiteContentExportController(WebsiteContentExportService exportService) {
        this.exportService = exportService;
    }

    @GetMapping("/export")
    public ResponseEntity<WebsiteContentExportResponse> exportAllContent() {
        return ResponseEntity.ok(exportService.exportAllContent());
    }

    @GetMapping("/items/{nodeId}")
    public ResponseEntity<WebsiteContentItemDto> getContentById(
            @PathVariable String nodeId
    ) {
        return ResponseEntity.ok(exportService.getContentById(nodeId));
    }

    @GetMapping("/files/{nodeId}")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable String nodeId
    ) {
        Resource resource = exportService.downloadFile(nodeId);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}