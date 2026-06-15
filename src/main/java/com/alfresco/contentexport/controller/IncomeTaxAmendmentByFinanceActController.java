package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/api/v1/IncomeTaxAmendmentByFinanceAct",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class IncomeTaxAmendmentByFinanceActController {

    private static final String FOLDER_ID =
            "1080a58e-bd58-4fa7-a7c6-c0702687e9ab";

    private final AlfrescoClient alfrescoClient;

    public IncomeTaxAmendmentByFinanceActController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/incomeTax")
    public ResponseEntity<DocListShortResponse> getIncomeTaxAmendments() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(FOLDER_ID);



        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}