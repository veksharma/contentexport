package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/insolvency", produces = MediaType.APPLICATION_JSON_VALUE)
public class InsolvencyController {

    public static final String ACTS_NEW = "1a23d6c3-3045-4a4a-b90e-f5beb345f7d5";
    public static final String CIRCULARS = "46a1292c-a51e-4c4d-b833-da8d1a8cae3c";
    public static final String JUDGEMENT = "8b84ae86-90ba-43e7-9227-d05947ffd987";
    public static final String NOTIFICATIONS = "a8563b94-56a6-46be-927d-869cba8003eb";
    public static final String REGULATIONS_NEW = "743543e6-12b3-4072-82ff-b9553c196f02";
    public static final String RULES_NEW = "bea5ed6c-a4c9-4201-8c69-969063d162a6";

    private final AlfrescoClient alfrescoClient;

    public InsolvencyController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/acts")
    public ResponseEntity<DocListShortResponse> getActs() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(ACTS_NEW);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }



    @GetMapping("/circulars")
    public ResponseEntity<DocListShortResponse> getCirculars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(CIRCULARS);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/judgement")
    public ResponseEntity<DocListShortResponse> getJudgement() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(JUDGEMENT);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }


    @GetMapping("/notifications")
    public ResponseEntity<DocListShortResponse> getNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(NOTIFICATIONS);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/regulations")
    public ResponseEntity<DocListShortResponse> getRegulations() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(REGULATIONS_NEW);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/rules")
    public ResponseEntity<DocListShortResponse> getRules() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(RULES_NEW);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}