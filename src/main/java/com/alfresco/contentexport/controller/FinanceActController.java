package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/finance")
public class FinanceActController {


    public static final String financeAct  = "0703bed4-7eca-4121-8a4c-08380e34242c";

    private final AlfrescoClient alfrescoClient;
    public FinanceActController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/financeAct")
    public ResponseEntity<DocListShortResponse> getGstActs() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(financeAct);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
