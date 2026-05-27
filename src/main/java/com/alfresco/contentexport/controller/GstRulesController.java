package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstRulesNewrt")
public class GstRulesController {

    public static final String gstRulesNewrt = "d62f8761-e51f-4cde-a5c4-bfd25ec0461f";

    private final AlfrescoClient alfrescoClient;
    public GstRulesController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstRules")
    public ResponseEntity<DocListShortResponse> getGstRulesNewrt() {        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstRulesNewrt);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
