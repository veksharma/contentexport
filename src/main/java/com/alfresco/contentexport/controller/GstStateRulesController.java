package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstStateRules")
public class GstStateRulesController {

    public static final String gstStateRules = "4967ccc2-7b36-4b44-bac7-0344210f857b";

    private final AlfrescoClient alfrescoClient;
    public GstStateRulesController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstStateRules")
    public ResponseEntity<DocListShortResponse> getGstStateRules() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstStateRules);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
