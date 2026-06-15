package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstStateDraftForms")
public class GstStateDraftFormsController {

    // Replace with actual GST State Draft Forms folder NodeId
    private static final String GST_STATE_DRAFT_FORMS =
            "a119e20d-ce5a-422b-8a9a-a66ed9c2febf";

    private final AlfrescoClient alfrescoClient;

    public GstStateDraftFormsController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/getStateDraftForms")
    public ResponseEntity<DocListShortResponse> getStateDraftForms() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(GST_STATE_DRAFT_FORMS);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}