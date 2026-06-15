package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/gstReferencerGoodsService", produces = MediaType.APPLICATION_JSON_VALUE)
public class GstReferencerGoodsService {

    // Replace with actual Alfresco folder node ID
    public static final String gstReferencerGoodsService =
            "eacc808b-e32f-43c0-8235-7fe7f07c3d8c";

    private final AlfrescoClient alfrescoClient;

    public GstReferencerGoodsService(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstReferencerGoodsService")
    public ResponseEntity<DocListShortResponse> getGstReferencerGoodsService() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(
                        gstReferencerGoodsService);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}