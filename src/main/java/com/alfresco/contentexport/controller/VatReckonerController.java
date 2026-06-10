package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vatReckoner")
public class VatReckonerController {

    public static final String vatReckoner = "826176ac-6494-4edf-acde-a5fa751f28cb";

    private final AlfrescoClient alfrescoClient;
    public VatReckonerController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/vatReadyReckoner")
    public ResponseEntity<DocListShortResponse> getGstExperts() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(vatReckoner);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
