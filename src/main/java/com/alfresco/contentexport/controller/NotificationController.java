package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<DocListResponse> getExciseNotifications() {
        ResponseEntity<DocListResponse> response =
                alfrescoClient.getFolderChildrenAsDocList("74394101-0e23-4eed-95e3-b35362f8ea6c");

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}