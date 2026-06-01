package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customRules")
public class CustomRulesController {

    public static final String customRules = "7e86c43f-0b46-417c-aafd-b9965683ba9c";

    private final AlfrescoClient alfrescoClient;

    public CustomRulesController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/customRules")
    public ResponseEntity<DocListShortResponse> getCentralExcise() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customRules);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

//    public static final String centralExcise = "a9604d10-8e91-47b8-821b-12751ce5cbef";
//
//    public static final String customsFolder = "9c35155e-6fa8-48c8-976d-862c4141120f";
//
//    public static final String serviceTax = "9ac26679-eb6b-43ac-92c7-8255f5a7026c";
//
//    public static final String ceRules2017 = "f93c8488-18ce-40ec-9104-63f28a235982";
//
//    public static final String cenvat2004 = "285d611b-3c86-400e-9216-1d0f02f4cea5";
//
//    public static final String cenvat2017 = "92c5b4e6-67ef-4051-ad41-0a4c8af7406f";
//
//    public static final String cestat1982 = "43a18662-5156-4fbd-ac90-646bcabcc14a";
//
//    public static final String drawback2017 = "c948f60a-a9e0-49c7-a714-58f3ce22ed2b";
//
//    public static final String exportServices2005 = "0280990a-c47b-47c6-8fb5-6fdce89c0be8";
//
//    public static final String pops2012 = "e53a5296-8656-42ad-9aae-ff4695ff01c9";
//
//    public static final String pointTax2011 = "ed953af0-873c-43df-86f3-cc03d7365c88";
//
//    public static final String stAdvance2003 = "bcfde187-f6ea-4f5e-903f-8d8e8b69ad85";
//
//    public static final String stCompounding2012 = "2284b7f1-ab19-4940-87f7-032132ff934a";
//
//    public static final String stValue2006 = "6907d101-fc1c-483d-8641-4e821eb0286f";
//
//    public static final String stAttachment2008 = "3393237a-56b1-41e1-9fe1-ffd499996fb1";
//
//    public static final String stPublication2008 = "efb3d12f-153a-4232-a3b4-ff3b95a8169d";
//
//    public static final String stSettlement2012 = "d349eeb5-e3a8-47c5-b183-8c9fac16b307";
//
//    public static final String air2016 = "e0ab2dc1-47d4-4902-9755-91f4b8e16e5d";
//
//    public static final String stRules1994 = "651510a4-399e-4994-a683-23364b284c17";
//
//    public static final String vcesRules2013 = "b24a91f1-1d8a-439c-ad12-be9205d0125b";
//
//    public static final String importService2006 = "90534bb8-9ee5-4305-9fb8-557c93b374ff";
//
//    public static final String worksContract2007 = "13dd4fc1-0b51-44d0-9e6f-49b16d3f8b95";
//
//    public static final String customValuation2017 = "0d46225f-633d-45e9-9bf2-910177ea8add";
//
//    public static final String indirectTaxRules2016 = "3c636ea1-6c24-42b9-adb3-6f0593179d6d";
//
//    public static final String stRegistration2005 = "50b3f29d-3337-4e85-a182-74220e2088a2";
//
//    public static final String svlrsRules2019 = "d741f28c-ab8f-4254-beca-58e883f3f577";
//
//    public static final String baggage2016 = "a9960147-54d0-46be-891b-e043f4a12e11";
//
//    public static final String customsAdvance2002 = "2bd9f0c1-af3d-447f-8665-9e1b1261aaf9";
//
//    public static final String concessionalDuty2017 = "f8024b53-4384-40b0-b23a-0ab4109dc02b";
//
//    public static final String ldcs2015 = "9d6e901c-9475-43ec-b1e2-bdc818370422";
//
//    public static final String exportGoods2007 = "937a1880-8298-40ca-ac5c-98104dba11aa";
//
//    public static final String indiaJapan2017 = "d471e69e-38d9-44c2-bab1-64cca357f1b0";
//
//    public static final String indiaKorea2017 = "581d7be1-df3a-416d-a497-ff7d520967a0";
//
//    public static final String customsInfo2017 = "75bc888e-0140-4055-aaaf-29c34197c837";
//
//    public static final String indiaMalaysia2017 = "34672000-c556-49f8-915e-55db94fc41fe";
//
//    public static final String accessories1963 = "688e487e-05a3-4eb3-a96b-60b56e0b5c1a";
//
//    public static final String customsRecovery1995 = "72af4ba7-bc71-4afd-a6ee-e0779d231ce6";
//
//    public static final String customsCompounding2005 = "eb82214f-1205-40d8-ba3c-2b368643715d";
//
//    public static final String concessionalExcisable2016 = "18d7ffe8-6edc-4d90-a39d-7a597953b1b3";
//
//    public static final String customsPublication1975 = "2b430d12-38ca-4296-afa5-cc6e6904fa3b";
//
//    public static final String foreignPrivileges1957 = "6b961f2b-3d8c-4623-a24d-d2aced8a472f";
//
//    public static final String denaturing1972 = "68d94bf2-e867-4671-bb4f-9e8852d84f00";
//
//    public static final String deferredDuty2016 = "ebd75492-0b50-4b78-b75a-8f8141f377d6";
//
//    public static final String safeguard2002 = "b1d8b00f-8d2b-407e-ab98-47fa192cd377";
//
//    public static final String safeguard1997 = "2b3947c6-17e3-4da8-b59b-ad6a67c9a32e";
//
//    public static final String antiDumping2012 = "46f731bc-6be5-43c9-aaa9-005bef03fc91";
//
//    public static final String importExport2004 = "b2d7a348-ba7e-45bf-8f7c-9be34310e72b";
//
//    public static final String refundDumping2012 = "f52ebeaa-8b17-4932-a4d4-adb67c17d9ee";
//
//    public static final String customsValuation2007 = "69fd1c5e-0177-43c1-a022-556309bcdb3a";
//
//    public static final String tribunal2020 = "6247c562-7f22-4f2d-997c-2e6bde15bdb7";
//
//    public static final String cst1957 = "4c946f1b-5213-4a79-9169-d9c6be5bc1bd";
//
//    public static final String customsAppeals1982 = "cd36f8a5-14cd-43f9-b915-3451bb8b4cf1";
//
//    public static final String reExport1995 = "fc5654e8-6bc1-4160-92d7-0646cee3a99c";
//
//    public static final String cvd2006 = "4e334d7b-7a38-4f62-979d-3bbc60797520";
//
//    public static final String cleanEnergy2010 = "4c12f7b5-d187-40d0-afad-e021cf9d7d6b";
//
//    public static final String welfare1992 = "6ac93230-38fb-4715-9c45-285aab223297";
//
//    public static final String indirectTax2016 = "d7e8020a-c1c4-4936-b4f8-e35423c82733";
//
//    public static final String panMasala2008 = "cf349005-ef80-44d0-881a-6dbe92cbf19b";
//
//    public static final String mauritius2021 = "9dfcf537-d820-452c-8f34-0ce4c2f93c64";
//
//    public static final String uae2022 = "8f18929d-5841-4603-abb9-e9692f916894";
//
//    public static final String customsCompounding2022 = "062ed72f-da9d-4946-bdcc-255b14d17ab6";
//
//    public static final String australia2022 = "355e33fc-10ab-4b59-8fd2-913892e2a77d";
//
//    public static final String customsAssistance2023 = "cd2e3ad8-0ff2-4d14-98b5-ab8bdd59964b";
//
//    public static final String antiDumping2024 = "2d6f9857-ba0e-4063-9719-f04d822b6f3e";
//
//    public static final String rulesOrigin2025 = "529d8b96-fbe1-4021-a3ff-198149b85eca";
//
//    public static final String baggage2026 = "5ad3139f-a5ce-4b10-9aff-199218a09327";

//    private final AlfrescoClient alfrescoClient;
//
//    public CustomRulesController(AlfrescoClient alfrescoClient) {
//        this.alfrescoClient = alfrescoClient;
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
//    @GetMapping("/ceRules2017")
//    public ResponseEntity<DocListShortResponse> getCeRules2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(ceRules2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cenvat2004")
//    public ResponseEntity<DocListShortResponse> getCenvat2004() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cenvat2004);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cenvat2017")
//    public ResponseEntity<DocListShortResponse> getCenvat2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cenvat2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cestat1982")
//    public ResponseEntity<DocListShortResponse> getCestat1982() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cestat1982);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/drawback2017")
//    public ResponseEntity<DocListShortResponse> getDrawback2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(drawback2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/exportServices2005")
//    public ResponseEntity<DocListShortResponse> getExportServices2005() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(exportServices2005);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/pops2012")
//    public ResponseEntity<DocListShortResponse> getPops2012() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(pops2012);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/pointTax2011")
//    public ResponseEntity<DocListShortResponse> getPointTax2011() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(pointTax2011);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stAdvance2003")
//    public ResponseEntity<DocListShortResponse> getStAdvance2003() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stAdvance2003);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stCompounding2012")
//    public ResponseEntity<DocListShortResponse> getStCompounding2012() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stCompounding2012);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stValue2006")
//    public ResponseEntity<DocListShortResponse> getStValue2006() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stValue2006);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stAttachment2008")
//    public ResponseEntity<DocListShortResponse> getStAttachment2008() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stAttachment2008);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stPublication2008")
//    public ResponseEntity<DocListShortResponse> getStPublication2008() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stPublication2008);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stSettlement2012")
//    public ResponseEntity<DocListShortResponse> getStSettlement2012() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stSettlement2012);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/air2016")
//    public ResponseEntity<DocListShortResponse> getAir2016() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(air2016);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stRules1994")
//    public ResponseEntity<DocListShortResponse> getStRules1994() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stRules1994);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/vcesRules2013")
//    public ResponseEntity<DocListShortResponse> getVcesRules2013() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(vcesRules2013);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/importService2006")
//    public ResponseEntity<DocListShortResponse> getImportService2006() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(importService2006);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/worksContract2007")
//    public ResponseEntity<DocListShortResponse> getWorksContract2007() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(worksContract2007);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customValuation2017")
//    public ResponseEntity<DocListShortResponse> getCustomValuation2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customValuation2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/indirectTaxRules2016")
//    public ResponseEntity<DocListShortResponse> getIndirectTaxRules2016() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(indirectTaxRules2016);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/stRegistration2005")
//    public ResponseEntity<DocListShortResponse> getStRegistration2005() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(stRegistration2005);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/svlrsRules2019")
//    public ResponseEntity<DocListShortResponse> getSvlrsRules2019() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(svlrsRules2019);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/baggage2016")
//    public ResponseEntity<DocListShortResponse> getBaggage2016() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(baggage2016);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsAdvance2002")
//    public ResponseEntity<DocListShortResponse> getCustomsAdvance2002() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsAdvance2002);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/concessionalDuty2017")
//    public ResponseEntity<DocListShortResponse> getConcessionalDuty2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(concessionalDuty2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/ldcs2015")
//    public ResponseEntity<DocListShortResponse> getLdcs2015() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(ldcs2015);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/exportGoods2007")
//    public ResponseEntity<DocListShortResponse> getExportGoods2007() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(exportGoods2007);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/indiaJapan2017")
//    public ResponseEntity<DocListShortResponse> getIndiaJapan2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(indiaJapan2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/indiaKorea2017")
//    public ResponseEntity<DocListShortResponse> getIndiaKorea2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(indiaKorea2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsInfo2017")
//    public ResponseEntity<DocListShortResponse> getCustomsInfo2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsInfo2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/indiaMalaysia2017")
//    public ResponseEntity<DocListShortResponse> getIndiaMalaysia2017() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(indiaMalaysia2017);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/accessories1963")
//    public ResponseEntity<DocListShortResponse> getAccessories1963() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(accessories1963);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsRecovery1995")
//    public ResponseEntity<DocListShortResponse> getCustomsRecovery1995() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsRecovery1995);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsCompounding2005")
//    public ResponseEntity<DocListShortResponse> getCustomsCompounding2005() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsCompounding2005);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/concessionalExcisable2016")
//    public ResponseEntity<DocListShortResponse> getConcessionalExcisable2016() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(concessionalExcisable2016);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsPublication1975")
//    public ResponseEntity<DocListShortResponse> getCustomsPublication1975() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsPublication1975);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/foreignPrivileges1957")
//    public ResponseEntity<DocListShortResponse> getForeignPrivileges1957() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(foreignPrivileges1957);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/denaturing1972")
//    public ResponseEntity<DocListShortResponse> getDenaturing1972() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(denaturing1972);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/deferredDuty2016")
//    public ResponseEntity<DocListShortResponse> getDeferredDuty2016() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(deferredDuty2016);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/safeguard2002")
//    public ResponseEntity<DocListShortResponse> getSafeguard2002() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(safeguard2002);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/safeguard1997")
//    public ResponseEntity<DocListShortResponse> getSafeguard1997() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(safeguard1997);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/antiDumping2012")
//    public ResponseEntity<DocListShortResponse> getAntiDumping2012() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(antiDumping2012);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/importExport2004")
//    public ResponseEntity<DocListShortResponse> getImportExport2004() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(importExport2004);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/refundDumping2012")
//    public ResponseEntity<DocListShortResponse> getRefundDumping2012() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(refundDumping2012);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsValuation2007")
//    public ResponseEntity<DocListShortResponse> getCustomsValuation2007() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsValuation2007);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/tribunal2020")
//    public ResponseEntity<DocListShortResponse> getTribunal2020() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(tribunal2020);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cst1957")
//    public ResponseEntity<DocListShortResponse> getCst1957() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cst1957);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsAppeals1982")
//    public ResponseEntity<DocListShortResponse> getCustomsAppeals1982() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsAppeals1982);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/reExport1995")
//    public ResponseEntity<DocListShortResponse> getReExport1995() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(reExport1995);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cvd2006")
//    public ResponseEntity<DocListShortResponse> getCvd2006() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cvd2006);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cleanEnergy2010")
//    public ResponseEntity<DocListShortResponse> getCleanEnergy2010() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cleanEnergy2010);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/welfare1992")
//    public ResponseEntity<DocListShortResponse> getWelfare1992() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(welfare1992);
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
//    @GetMapping("/panMasala2008")
//    public ResponseEntity<DocListShortResponse> getPanMasala2008() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(panMasala2008);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/mauritius2021")
//    public ResponseEntity<DocListShortResponse> getMauritius2021() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(mauritius2021);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/uae2022")
//    public ResponseEntity<DocListShortResponse> getUae2022() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(uae2022);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsCompounding2022")
//    public ResponseEntity<DocListShortResponse> getCustomsCompounding2022() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsCompounding2022);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/australia2022")
//    public ResponseEntity<DocListShortResponse> getAustralia2022() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(australia2022);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/customsAssistance2023")
//    public ResponseEntity<DocListShortResponse> getCustomsAssistance2023() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(customsAssistance2023);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/antiDumping2024")
//    public ResponseEntity<DocListShortResponse> getAntiDumping2024() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(antiDumping2024);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/rulesOrigin2025")
//    public ResponseEntity<DocListShortResponse> getRulesOrigin2025() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(rulesOrigin2025);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/baggage2026")
//    public ResponseEntity<DocListShortResponse> getBaggage2026() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(baggage2026);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
}
