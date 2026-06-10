package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/custom")
public class CustomActController {

    public static final String customAct = "d7c567c1-6f29-4e71-933d-4a61fc1714b9";

//    public static final String serviceTax = "1e0af748-49ae-4271-83d7-a8c5bee6b80f";
//
//    public static final String centralExcise = "81a24ab3-fc75-4d85-93ad-0a21993d0f59";
//
//    public static final String customsFolder = "1e42e726-33c9-4b69-ad21-1f2fe36b7d38";
//
//    public static final String financeAct1994 = "75ef9891-f1ac-4bba-85ea-89a8d1a3c2fd";
//
//    public static final String ceAct1944Extract = "59e8d820-4d21-4581-b343-a4944e267fb6";
//
//    public static final String customsAct1962Extract = "001d5e08-d006-4ee6-8009-95e62fab988c";
//
//    public static final String stReturn2009 = "4434deef-5ca9-4800-9d4d-0498294bdef7";
//
//    public static final String vces2013 = "c6fa9d48-2a74-4519-978b-80b14c89ede5";
//
//    public static final String ceAct1944 = "a879c16f-f4ff-4aeb-944a-b46af7841433";
//
//    public static final String indirectTax2016 = "ec5ee958-2938-4403-a0bf-2ff0b0fa3b8b";
//
//    public static final String taxAmendment2017 = "ceb9ccef-02f7-40b9-a3ca-b9e1503db430";
//
//    public static final String customsAct2020 = "f9c4bbc3-60d8-44e6-8333-f350ba04afc1";
//
//    public static final String customsTariff2020 = "9bf3513d-c8b4-472c-8db4-576c104d7f6e";
//
//    public static final String cst1956 = "9ee7d5d8-a1f8-47dd-b918-0078296ca866";
//
//    public static final String healthCess2020 = "bdc1415f-ad09-4474-8149-159f6fc51b27";
//
//    public static final String svlrs2019 = "97fb66ae-aac1-4b8a-8bc9-7ff1a0465b7c";
//
//    public static final String stDispute2008 = "1c0c12fc-29e6-419b-8880-5acc99345e6c";
//
//    public static final String customsAct2021 = "997aa02d-1eb6-40fa-bb28-cf37947fb89b";
//
//    public static final String customsTariff2021 = "0924dd6e-3c70-48e1-ab12-0a62d7f51801";
//
//    public static final String customsAct2023 = "a630b645-098b-483d-ade4-4c433b6fa07b";
//
//    public static final String customsTariff2023 = "edfe3951-d707-4bee-a324-12b18f47ba62";

    private final AlfrescoClient alfrescoClient;

    public CustomActController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/customAct")
    public ResponseEntity<DocListShortResponse> getCustomsActs() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customAct);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

//    @GetMapping("/customsTariff2023")
//    public ResponseEntity<DocListShortResponse> getCustomsTariff2023() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsTariff2023);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }

//    @GetMapping("/serviceTax")
//    public ResponseEntity<DocListShortResponse> getServiceTax() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(serviceTax);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/centralExcise")
//    public ResponseEntity<DocListShortResponse> getCentralExcise() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(centralExcise);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsFolder")
//    public ResponseEntity<DocListShortResponse> getCustomsFolder() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsFolder);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/financeAct1994")
//    public ResponseEntity<DocListShortResponse> getFinanceAct1994() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(financeAct1994);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/ceAct1944Extract")
//    public ResponseEntity<DocListShortResponse> getCeAct1944Extract() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(ceAct1944Extract);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsAct1962Extract")
//    public ResponseEntity<DocListShortResponse> getCustomsAct1962Extract() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsAct1962Extract);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stReturn2009")
//    public ResponseEntity<DocListShortResponse> getStReturn2009() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stReturn2009);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/vces2013")
//    public ResponseEntity<DocListShortResponse> getVces2013() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(vces2013);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/ceAct1944")
//    public ResponseEntity<DocListShortResponse> getCeAct1944() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(ceAct1944);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/indirectTax2016")
//    public ResponseEntity<DocListShortResponse> getIndirectTax2016() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(indirectTax2016);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/taxAmendment2017")
//    public ResponseEntity<DocListShortResponse> getTaxAmendment2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(taxAmendment2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsAct2020")
//    public ResponseEntity<DocListShortResponse> getCustomsAct2020() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsAct2020);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsTariff2020")
//    public ResponseEntity<DocListShortResponse> getCustomsTariff2020() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsTariff2020);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cst1956")
//    public ResponseEntity<DocListShortResponse> getCst1956() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cst1956);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/healthCess2020")
//    public ResponseEntity<DocListShortResponse> getHealthCess2020() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(healthCess2020);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/svlrs2019")
//    public ResponseEntity<DocListShortResponse> getSvlrs2019() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(svlrs2019);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stDispute2008")
//    public ResponseEntity<DocListShortResponse> getStDispute2008() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stDispute2008);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsAct2021")
//    public ResponseEntity<DocListShortResponse> getCustomsAct2021() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsAct2021);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsTariff2021")
//    public ResponseEntity<DocListShortResponse> getCustomsTariff2021() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsTariff2021);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsAct2023")
//    public ResponseEntity<DocListShortResponse> getCustomsAct2023() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsAct2023);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsTariff2023")
//    public ResponseEntity<DocListShortResponse> getCustomsTariff2023() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsTariff2023);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }

}
