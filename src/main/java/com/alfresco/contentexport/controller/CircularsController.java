package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/circulars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CircularsController {

    public static final String CGST= "3a83517d-fc8d-44c3-bc66-0a9b4207bdd1";
    public static final String compensation= "bea0b8a4-393e-4574-a54b-c04ea5bd89de";
    public static final String customsFolder= "e8e20bd8-441d-4677-a511-43c5ecd65390";
    public static final String excise= "50b243a5-489c-4ff8-bf2c-6c6c5a7ba23c";
    public static final String IGST= "87c3ede8-d8bc-4d56-8c46-e1033fb16802";
    public static final String serviceTax= "f1fc6c8e-5180-4e43-820b-b02c81729e9a";
    public static final String SVLDRS= "2802c253-f6ba-4cad-8d0e-844c8cef18a2";
    public static final String UTGST= "780b1f0b-a549-4700-a70f-6c2a2e2290a7";
    public static final String gstPressReleases= "f6944392-40dd-4f9e-8540-34bb34dec6da";

    private final AlfrescoClient alfrescoClient;

    public CircularsController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/cgst")
    public ResponseEntity<DocListShortResponse> getCgstCiruclars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(CGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/compensation")
    public ResponseEntity<DocListShortResponse> getCompensationCirculars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(compensation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/customsFolder")
    public ResponseEntity<DocListShortResponse> getCustomsFolderCirculars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customsFolder);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/excise")
    public ResponseEntity<DocListShortResponse> getExciseCirculars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(excise);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/igst")
    public ResponseEntity<DocListShortResponse> getIgstCirculars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(IGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/serviceTax")
    public ResponseEntity<DocListShortResponse> getServiceTaxCirculars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(serviceTax);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/svldrs")
    public ResponseEntity<DocListShortResponse> getSvldrsCirculars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(SVLDRS);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/utgst")
    public ResponseEntity<DocListShortResponse> getUtgstCirculars() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(UTGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/gstPressReleases")
    public ResponseEntity<DocListShortResponse> getgstPressReleases() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstPressReleases);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
