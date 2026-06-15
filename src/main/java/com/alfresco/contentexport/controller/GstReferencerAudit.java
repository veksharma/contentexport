package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/gstReferencerAudit", produces = MediaType.APPLICATION_JSON_VALUE)
public class GstReferencerAudit {

    // Replace with actual Alfresco folder node ID
    public static final String gstReferencerAudit =
            "cb9cdc05-8ca7-4031-8903-3323e31aa825";

    private final AlfrescoClient alfrescoClient;

    public GstReferencerAudit(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstReferencerAudit")
    public ResponseEntity<DocListShortResponse> getGstReferencerAudit() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(
                        gstReferencerAudit);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}