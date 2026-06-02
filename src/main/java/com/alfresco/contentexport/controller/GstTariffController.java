package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstTeriff")
public class GstTariffController {

    public static final String tariffExemptedGoods = "b6109d77-35b8-42ec-9faa-47de1bcb449b";
    public static final String tariffExemptedService = "65009727-b207-4ca3-bfe6-12d8faed5d87";
    public static final String tariffGoods = "a74a1c24-3723-4451-81ac-72d44c676b00";
    public static final String tariffService = "7f73c77a-a5c8-4d26-8aae-fc29f014960e";

    private final AlfrescoClient alfrescoClient;

    public GstTariffController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }


    @GetMapping("/tariffExemptedGoods")
    public ResponseEntity<DocListShortResponse> getTariffExemptedGoods() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(tariffExemptedGoods);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/tariffExemptedService")
    public ResponseEntity<DocListShortResponse> getTariffExemptedService() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(tariffExemptedService);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/tariffGoods")
    public ResponseEntity<DocListShortResponse> getTariffGoods() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(tariffGoods);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/tariffService")
    public ResponseEntity<DocListShortResponse> getTariffService() {
        {
            ResponseEntity<DocListShortResponse> response =
                    alfrescoClient.getFolderChildrenAsDocList(tariffService);

            return ResponseEntity
                    .status(response.getStatusCode())
                    .body(response.getBody());
        }

    }

}
