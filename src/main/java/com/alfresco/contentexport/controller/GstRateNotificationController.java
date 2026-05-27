package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstTariff")
public class GstRateNotificationController {

    public static final String CGST = "30107934-d7c6-4c52-9758-c369e6386ec7";
    public static final String compensation= "cfb86345-2362-4955-ad23-5e04767b06e3";
    public static final String gstRatesGoods= "2fe41c0d-3749-40c7-9477-5ba9841244d9";
    public static final String gstRatesServices= "f04b7e56-ed8f-4464-b11b-fa1f521840d7";
    public static final String IGST= "259125d3-4b88-4ac1-b02c-d39a8b3e3586";
    public static final String SGST= "685e6e5d-4d2b-4929-bacb-30f35c272788";
    public static final String tariffRatePdf= "bc242de3-d542-4140-9971-0060c0878b19";
    public static final String UTGST = "d1089ae1-2393-44f0-ac56-e93198afe814";

    private final AlfrescoClient alfrescoClient;
    public GstRateNotificationController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/cgst")
    public ResponseEntity<DocListShortResponse> getCgstGstTariff() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(CGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/compensation")
    public ResponseEntity<DocListShortResponse> getCompensationGstTariff() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(compensation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/gstRatesGoods")
    public ResponseEntity<DocListShortResponse> getGstRatesGoodsGstTariff() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstRatesGoods);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/gstRatesServices")
    public ResponseEntity<DocListShortResponse> getGstRatesServicesGstTariff() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstRatesServices);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/igst")
    public ResponseEntity<DocListShortResponse> getIgstGstTariff() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(IGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/sgst")
    public ResponseEntity<DocListShortResponse> getSgstGstTariffs() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(SGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/tariffRatePdf")
    public ResponseEntity<DocListShortResponse> getTariffRatePdfsGstTariffs() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(tariffRatePdf);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/utgst")
    public ResponseEntity<DocListShortResponse> getUtgstGstTariffs() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(UTGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
