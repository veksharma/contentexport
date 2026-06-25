package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/readyReckonerGoodsService")
public class ReadyReckonerGoodsServiceController {

    public static final String READY_RECKONER_GOODS_SERVICE_FOLDER_ID =
            "8a9237ab-c560-40b4-8448-defa88da9784";

    private final AlfrescoClient alfrescoClient;

    public ReadyReckonerGoodsServiceController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/readyReckonerGoodsService")
    public ResponseEntity<DocListShortResponse> getReadyReckonerGoodsService() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(
                        READY_RECKONER_GOODS_SERVICE_FOLDER_ID);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}