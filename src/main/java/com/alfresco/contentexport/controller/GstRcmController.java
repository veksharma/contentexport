package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//GST-Valuation of Services and Reverse and Joint Charge Mechanism
@RestController
@RequestMapping("/api/v1/gstRcm")
public class GstRcmController {

    public static final String inputTaxCredit = "e9a530c9-48e5-43b8-a9e1-2960ab8385b4";
    public static final String valuationRcm = "eb7036f9-c190-4b27-9d3b-9027a6c7367c";

    private final AlfrescoClient alfrescoClient;
    public GstRcmController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/inputTaxCredit")
    public ResponseEntity<DocListShortResponse> getInputTaxCredit() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(inputTaxCredit);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/valuationRcm")
    public ResponseEntity<DocListShortResponse> getValuationRcm() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(valuationRcm);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
