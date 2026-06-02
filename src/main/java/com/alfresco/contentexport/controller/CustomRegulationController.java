package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customRegulation")
public class CustomRegulationController {

    public static final String customRegulation  = "592f187c-4203-4c9a-9790-92f77536cf27";

    private final AlfrescoClient alfrescoClient;
    public CustomRegulationController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/customRegulation")
    public ResponseEntity<DocListShortResponse> getGstActs() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customRegulation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
