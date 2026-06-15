package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    public static final String articleFolderId = "4fb66c38-f30b-400e-bbfa-81d69512877f";
    public static final String anInternationalPerspective = "7c12ed14-0272-4594-a4ac-29782089c549";
    public static final String deloitteDisquisition = "238e48e8-359d-4ef2-9bd5-21986f776cec";

    private final AlfrescoClient alfrescoClient;
    public ArticleController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/articleFolderId")
    public ResponseEntity<DocListShortResponse> getGstExperts() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(articleFolderId);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/anInternationalPerspective")
    public ResponseEntity<DocListShortResponse> getGstInternationalExperts() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(anInternationalPerspective);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/deloitteDisquisition")
    public ResponseEntity<DocListShortResponse> getGstDeloitteExperts() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(deloitteDisquisition);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
