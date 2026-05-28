package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/gstStateRules", produces = MediaType.APPLICATION_JSON_VALUE)
public class GstStateRulesController {

    public static final String gstStateRules = "4967ccc2-7b36-4b44-bac7-0344210f857b";

    private final AlfrescoClient alfrescoClient;
    public GstStateRulesController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstStateRules")
    public ResponseEntity<DocListShortResponse> getGstStateRules() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstStateRules);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(
                ContentDisposition.attachment()
                        .filename(gstStateRules)
                        .build()
        );

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
