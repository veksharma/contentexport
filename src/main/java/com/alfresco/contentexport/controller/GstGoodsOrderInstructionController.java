package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstGoodsOrderInstruction")
public class GstGoodsOrderInstructionController {

    public static final String GST_GOODS_ORDER_INSTRUCTION = "e606e40d-e524-46f4-994b-bdb6a4d506fd";

    private final AlfrescoClient alfrescoClient;

    public GstGoodsOrderInstructionController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/list")
    public ResponseEntity<DocListShortResponse> getGstGoodsOrderInstruction() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(GST_GOODS_ORDER_INSTRUCTION);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}