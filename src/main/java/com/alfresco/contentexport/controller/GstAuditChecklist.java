package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/gstAuditChecklist", produces = MediaType.APPLICATION_JSON_VALUE)
public class GstAuditChecklist {

    // Replace with actual Alfresco folder node ID
    public static final String gstAuditChecklist =
            "86cc395d-d89f-44f7-9d5a-24acfbd7a893";

    private final AlfrescoClient alfrescoClient;

    public GstAuditChecklist(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstAuditChecklist")
    public ResponseEntity<DocListShortResponse> getGstAuditChecklist() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(
                        gstAuditChecklist);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}