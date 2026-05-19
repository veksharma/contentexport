package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private final AlfrescoClient alfrescoClient;

    public NotificationController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/excise")
    public ResponseEntity<DocListShortResponse> getExciseNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList("74394101-0e23-4eed-95e3-b35362f8ea6c");

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
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