package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orderTradeNotice")
public class OrderTradeNoticeController {

    public static final String CGST= "af21695f-1ec7-4e71-8a8f-c0a7d5b12fa3";
    public static final String compensation= "156ab7ac-3ed4-469d-9274-108d7fd23b0c";
    public static final String customsFolder= "428eda19-1cd3-4bd7-a55e-bc324209aec8";
    public static final String excise= "43c2ec33-6e45-47c4-8eb0-74db8e7b1d62";
    public static final String IGST= "66176803-0b87-407f-862c-021a62052ebf";
    public static final String serviceTax= "994c7885-5988-46dc-ad1d-06d7465b0380";
    public static final String SVLDRS= "ec20e504-4e1e-4ee6-98c8-bc8c2f54499d";
    public static final String UTGST= "d111be18-bb0a-4f75-9579-770a4a58e3ee";


    private final AlfrescoClient alfrescoClient;

    public OrderTradeNoticeController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/cgst")
    public ResponseEntity<DocListShortResponse> getCgstOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(CGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/compensation")
    public ResponseEntity<DocListShortResponse> getCompensationOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(compensation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/customsFolder")
    public ResponseEntity<DocListShortResponse> getCustomsFolderOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customsFolder);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/excise")
    public ResponseEntity<DocListShortResponse> getExciseOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(excise);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/igst")
    public ResponseEntity<DocListShortResponse> getIgstOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(IGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/serviceTax")
    public ResponseEntity<DocListShortResponse> getServiceTaxOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(serviceTax);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/svldrs")
    public ResponseEntity<DocListShortResponse> getSvldrsOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(SVLDRS);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/utgst")
    public ResponseEntity<DocListShortResponse> getUtgstOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(UTGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
