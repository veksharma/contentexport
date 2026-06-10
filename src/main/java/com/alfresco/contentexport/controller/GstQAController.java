package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstqa")
public class GstQAController {

    public static final String departQA = "881fb3fb-b2a7-48a5-8956-cbafd243656b";
    public static final String expertQA = "881fb3fb-b2a7-48a5-8956-cbafd243656b";
    public static final String gstFAQ = "881fb3fb-b2a7-48a5-8956-cbafd243656b";

    private final AlfrescoClient alfrescoClient;
    public GstQAController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/departQA")
    public ResponseEntity<DocListShortResponse> getDepartQA() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(departQA);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/expertQA")
    public ResponseEntity<DocListShortResponse> getExpertQA() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(expertQA);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/gstFAQ")
    public ResponseEntity<DocListShortResponse> getGstFAQ() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstFAQ);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
