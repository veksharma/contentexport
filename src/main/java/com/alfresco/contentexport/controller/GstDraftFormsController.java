package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstDraftForms")
public class GstDraftFormsController {

    private static final String GST_DRAFT_FORMS =
            "4d03384f-248f-4eb4-abf4-65e3db1cabac";

    private final AlfrescoClient alfrescoClient;

    public GstDraftFormsController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/getDraftForms")
    public ResponseEntity<DocListShortResponse> getDraftForms() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(GST_DRAFT_FORMS);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}