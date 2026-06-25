package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstCommentary")
public class GstCommentaryController {

    public static final String GST_COMMENTARY_FOLDER_ID =
            "5fb464a2-e4c7-4c3e-9438-084a0e88e8f3";

    private final AlfrescoClient alfrescoClient;

    public GstCommentaryController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstCommentary")
    public ResponseEntity<DocListShortResponse> getGstCommentary() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(
                        GST_COMMENTARY_FOLDER_ID);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}