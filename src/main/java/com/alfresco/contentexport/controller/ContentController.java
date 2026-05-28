package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/content", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContentController {
    private final AlfrescoClient alfrescoClient;

    public ContentController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    //http://localhost:8080/api/v1/alfresco/nodes/1a0b110f-1e09-4ca2-b367-fe25e4964a4e/content
    @GetMapping("/download/{nodeId}")
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
}
