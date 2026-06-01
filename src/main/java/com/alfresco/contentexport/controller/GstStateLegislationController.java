package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstStateLegislation")
public class GstStateLegislationController {

    public static final String gstState = "92360676-c2fd-48b0-bd65-21bb1d3c0042";

        private final AlfrescoClient alfrescoClient;

    public GstStateLegislationController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

        @GetMapping("/gstState")
    public ResponseEntity<DocListShortResponse> getPunjabGST() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstState);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

//    public static final String punjabGST = "998e678c-4e43-4d57-9dd6-96f43b3a042c";
//
//    public static final String mpGST = "4c4c2193-8620-419f-b7d1-464f4b296e76";
//
//    public static final String upGST = "1e810d3b-3e3f-42f7-b25e-79a0aa988ed3";
//
//    public static final String goaGST = "c8157640-6b24-4e45-a2a3-f16f2b30a4fb";
//
//    public static final String hpGST = "5de4dd87-4622-4821-921a-87d225254458";
//
//    public static final String haryanaGST = "c5cb57cd-4b96-4621-804b-f5e4379d65be";
//
//    public static final String apGST = "0a85ca8f-77fd-4597-907d-f17ae760de4d";
//
//    public static final String tnGST = "51229e92-381b-42a9-8557-be592ab45045";
//
//    public static final String telanganaGST = "5fd6dab4-fab4-4903-a5ee-efc1991bef73";
//
//    public static final String keralaGST = "6a14a6ce-6bbe-4433-9128-df2d0173be16";
//
//    public static final String biharGST = "8f9dc4ec-18c4-4774-8acd-ccf7850a4fe0";
//
//    public static final String assamGST = "ac0365a5-753f-4cae-9feb-f513dbd824fa";
//
//    public static final String cgGST = "ddfeee86-abac-49da-bb52-d9d8ee740b07";
//
//    public static final String jharkhandGST = "8f76337f-1f85-41ed-9e4c-9d329ad22e63";
//
//    public static final String jkGST = "186e1149-2d0f-4bd8-9864-5418501eb8f3";
//
//    public static final String manipurGST = "8d816e1e-84f3-4b8b-8f7e-2953de33c54a";
//
//    public static final String meghalayaGST = "3aa1d244-d37b-4c07-bcfa-8636c9636881";
//
//    public static final String mizoramGST = "60f1ccf4-85aa-4823-9868-79a28f99a91a";
//
//    public static final String rajasthanGST = "c911c942-3ba5-46b6-8653-f484576872f5";
//
//    public static final String nagalandGST = "db31b288-82b4-4a9d-868d-bfde0be7f92c";
//
//    public static final String odishaGST = "f73ba3e4-48fb-40b5-b844-fa7f7d6568e8";
//
//    public static final String puducherryGST = "1c78f18c-0c11-48ff-b9b3-c46368529b58";
//
//    public static final String tripuraGST = "57d79296-3eca-44e0-8512-87c99d5fecdd";
//
//    public static final String sikkimGST = "738efb65-3bd3-40bc-9eb4-f49a75f7d919";
//
//    public static final String ukGST = "8c25ee29-a800-4ecb-8957-9ce3b49af69f";
//
//    public static final String hpGSTAlt = "72ff6128-ddf4-4c53-a603-9ef438283ed2";
//
//    public static final String delhiGST2019 = "fd181be3-1605-4f18-ad01-8680ad14085f";
//
//    public static final String maharashtraGST2020 = "6aaefa0a-7461-478f-acc8-4d8ed5ae2d80";
//
//    public static final String wbGST2019 = "e930001d-6c54-47dc-a55a-6f274c6de534";
//
//    public static final String gujaratGST2020 = "24dc293c-4d03-4761-81d5-0a356b97e7c4";
//
//    public static final String karnatakaGST2020 = "4d3e72f3-fd1a-4bcd-9be3-676c4406cb85";
//
//    public static final String mpGST2024 = "50a4d2ad-a21d-495a-9b8a-c35557a03adb";
//
//    public static final String goaGST2024 = "8753b48f-fa46-43e4-be46-9cbd082b1af0";
//
//    private final AlfrescoClient alfrescoClient;
//
//    public GstStateLegislationController(AlfrescoClient alfrescoClient) {
//        this.alfrescoClient = alfrescoClient;
//    }
//
//    @GetMapping("/punjabGST")
//    public ResponseEntity<DocListShortResponse> getPunjabGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(punjabGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/mpGST")
//    public ResponseEntity<DocListShortResponse> getMpGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(mpGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/upGST")
//    public ResponseEntity<DocListShortResponse> getUpGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(upGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/goaGST")
//    public ResponseEntity<DocListShortResponse> getGoaGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(goaGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/hpGST")
//    public ResponseEntity<DocListShortResponse> getHpGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(hpGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/haryanaGST")
//    public ResponseEntity<DocListShortResponse> getHaryanaGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(haryanaGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/apGST")
//    public ResponseEntity<DocListShortResponse> getApGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(apGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/tnGST")
//    public ResponseEntity<DocListShortResponse> getTnGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(tnGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/telanganaGST")
//    public ResponseEntity<DocListShortResponse> getTelanganaGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(telanganaGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/keralaGST")
//    public ResponseEntity<DocListShortResponse> getKeralaGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(keralaGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/biharGST")
//    public ResponseEntity<DocListShortResponse> getBiharGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(biharGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/assamGST")
//    public ResponseEntity<DocListShortResponse> getAssamGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(assamGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cgGST")
//    public ResponseEntity<DocListShortResponse> getCgGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cgGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/jharkhandGST")
//    public ResponseEntity<DocListShortResponse> getJharkhandGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(jharkhandGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/jkGST")
//    public ResponseEntity<DocListShortResponse> getJkGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(jkGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/manipurGST")
//    public ResponseEntity<DocListShortResponse> getManipurGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(manipurGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/meghalayaGST")
//    public ResponseEntity<DocListShortResponse> getMeghalayaGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(meghalayaGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/mizoramGST")
//    public ResponseEntity<DocListShortResponse> getMizoramGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(mizoramGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/rajasthanGST")
//    public ResponseEntity<DocListShortResponse> getRajasthanGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(rajasthanGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/nagalandGST")
//    public ResponseEntity<DocListShortResponse> getNagalandGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(nagalandGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/odishaGST")
//    public ResponseEntity<DocListShortResponse> getOdishaGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(odishaGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/puducherryGST")
//    public ResponseEntity<DocListShortResponse> getPuducherryGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(puducherryGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/tripuraGST")
//    public ResponseEntity<DocListShortResponse> getTripuraGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(tripuraGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/sikkimGST")
//    public ResponseEntity<DocListShortResponse> getSikkimGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(sikkimGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/ukGST")
//    public ResponseEntity<DocListShortResponse> getUkGST() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(ukGST);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/hpGSTAlt")
//    public ResponseEntity<DocListShortResponse> getHpGSTAlt() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(hpGSTAlt);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/delhiGST2019")
//    public ResponseEntity<DocListShortResponse> getDelhiGST2019() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(delhiGST2019);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/maharashtraGST2020")
//    public ResponseEntity<DocListShortResponse> getMaharashtraGST2020() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(maharashtraGST2020);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/wbGST2019")
//    public ResponseEntity<DocListShortResponse> getWbGST2019() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(wbGST2019);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/gujaratGST2020")
//    public ResponseEntity<DocListShortResponse> getGujaratGST2020() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(gujaratGST2020);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/karnatakaGST2020")
//    public ResponseEntity<DocListShortResponse> getKarnatakaGST2020() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(karnatakaGST2020);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/mpGST2024")
//    public ResponseEntity<DocListShortResponse> getMpGST2024() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(mpGST2024);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/goaGST2024")
//    public ResponseEntity<DocListShortResponse> getGoaGST2024() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(goaGST2024);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
}
