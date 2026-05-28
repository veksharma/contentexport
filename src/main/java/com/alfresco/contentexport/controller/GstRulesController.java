package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstRulesNewrt")
public class GstRulesController {

    public static final String cgstRulesOct = "95600d56-627a-4630-afdb-e3267942d61d";

    public static final String cgstRulesDec = "13211a1c-1c3f-4ce8-be04-1529afd52c47";

    public static final String gstSettlement = "eac3104c-2332-43ba-9deb-5d55f2e8dbf8";

    public static final String gstdCollectionOfCess = "9a7ff240-5931-465f-9f00-4489a8c82c65";

    public static final String gstatAppointment = "657a79e0-d3e1-462a-8294-121f9d5be016";

    public static final String gstatAppointmentRules = "b3fac89c-77f2-4b2a-ae4c-5a99f09f9a67";

    public static final String gstatProcedure = "d2723d60-e34a-4d02-b1b5-5cedc712e356";

    public static final String gstGroupCEmployees = "27db4b70-8f9e-4b9b-b6e7-bc5b56b50dba";

    public static final String gstCompensation = "062883ee-b285-494e-8f05-2c8d47b57e31";

    public static final String igstRules2017 = "30a12405-0e46-4130-b3f5-3e6dc41bd67d";

    private final AlfrescoClient alfrescoClient;
    public GstRulesController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/cgstRulesOct")
    public ResponseEntity<DocListShortResponse> getGstRulesOct() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(cgstRulesOct);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/cgstRulesDec")
    public ResponseEntity<DocListShortResponse> getGstRulesDec() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(cgstRulesDec);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/gstSettlement")
    public ResponseEntity<DocListShortResponse> getGstSettlement() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstSettlement);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
    @GetMapping("/gstdCollectionOfCess")
    public ResponseEntity<DocListShortResponse> getGstdCollectionOfCess() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstdCollectionOfCess);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
    @GetMapping("/gstatAppointment")
    public ResponseEntity<DocListShortResponse> getGstatAppointment() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstatAppointment);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
    @GetMapping("/gstatAppointmentRules")
    public ResponseEntity<DocListShortResponse> getGstatAppointmentRules() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstatAppointmentRules);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
    @GetMapping("/gstatProcedure")
    public ResponseEntity<DocListShortResponse> getGstatProcedure() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstatProcedure);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
    @GetMapping("/gstGroupCEmployees")
    public ResponseEntity<DocListShortResponse> getGstGroupCEmployees() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstGroupCEmployees);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
    @GetMapping("/gstCompensation")
    public ResponseEntity<DocListShortResponse> getGstCompensation() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstCompensation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
    @GetMapping("/igstRules2017")
    public ResponseEntity<DocListShortResponse> getIgstRules2017() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(igstRules2017);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
