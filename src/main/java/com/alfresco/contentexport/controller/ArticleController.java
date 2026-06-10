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

}
