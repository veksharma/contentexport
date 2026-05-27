package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/forms")
public class FormController {

    public static final String forms = "81c0f671-41ef-4eec-9a80-e6d6407112ec";

    private final AlfrescoClient alfrescoClient;
    public FormController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/forms")
    public ResponseEntity<DocListShortResponse> getForm() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(forms);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
