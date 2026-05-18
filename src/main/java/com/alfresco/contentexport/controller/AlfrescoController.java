package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/alfresco")
public class AlfrescoController {

    private final AlfrescoClient alfrescoClient;

    public AlfrescoController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/nodes/{nodeId}/metadata")
    public ResponseEntity<String> getNodeMetadata(@PathVariable String nodeId) {
        ResponseEntity<String> response = alfrescoClient.getNodeMetadata(nodeId);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/nodes/{nodeId}/content")
    public ResponseEntity<byte[]> downloadContent(@PathVariable String nodeId) {
        ResponseEntity<byte[]> response = alfrescoClient.getNodeContent(nodeId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(
                ContentDisposition.attachment()
                        .filename(nodeId)
                        .build()
        );

        return new ResponseEntity<>(
                response.getBody(),
                headers,
                response.getStatusCode()
        );
    }

    @GetMapping("/search")
    public ResponseEntity<String> search(@RequestParam String q) {
        ResponseEntity<String> response = alfrescoClient.search(q);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/sites")
    public ResponseEntity<String> getSites() {
        ResponseEntity<String> response = alfrescoClient.getSites();

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/sites/{siteShortName}/document-library")
    public ResponseEntity<String> getSiteDocumentLibrary(@PathVariable String siteShortName) {
        ResponseEntity<String> response = alfrescoClient.getSiteDocumentLibrary(siteShortName);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/folders/{folderNodeId}/children")
    public ResponseEntity<String> getFolderChildren(@PathVariable String folderNodeId) {
        ResponseEntity<String> response = alfrescoClient.getFolderChildren(folderNodeId);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}