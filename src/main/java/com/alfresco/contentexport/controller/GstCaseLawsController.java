package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstCaseLaws")
public class GstCaseLawsController {

    public static final String GST_CASE_LAWS_ID =
            "42864f23-8c1c-43e3-9c18-b99fe6a61fb0";

    private final AlfrescoClient alfrescoClient;

    public GstCaseLawsController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/getCaseLaws")
    public ResponseEntity<DocListShortResponse> getCaseLaws(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        System.out.println("Page = " + page);
        System.out.println("Size = " + size);

        return alfrescoClient.getFolderChildrenAsDocListWithPagination(
                GST_CASE_LAWS_ID,
                page,
                size
        );
    }
}
