package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstOrdinance")
public class GstOrdinanceController {


    public static final String CGST= "c5a7c023-40b8-444c-b918-b077cfac1e93";
    public static final String compensation= "beadbf90-1ef7-4ea5-ba1c-5bbf8f0c2623";
    public static final String customsFolder= "b68ee895-4916-49f6-bcad-7e5435662920";
    public static final String excise= "98bb1127-4bd6-4289-8c37-15d9ee718f22";
    public static final String IGST= "56d04b65-0ac2-415d-b624-8223502b7954";
    public static final String serviceTax= "ca1d3cf0-251c-445a-92d4-c85dc432c930";
    public static final String UTGST= "00365671-6f71-4d73-b74a-d00afc3e2eda";

    private final AlfrescoClient alfrescoClient;

    public GstOrdinanceController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/cgst")
    public ResponseEntity<DocListShortResponse> getCgstOrdinance() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(CGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/compensation")
    public ResponseEntity<DocListShortResponse> getCompensationOrdinance() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(compensation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/customsFolder")
    public ResponseEntity<DocListShortResponse> getCustomsFolderOrdinance() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customsFolder);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/excise")
    public ResponseEntity<DocListShortResponse> getExciseOrdinance() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(excise);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/igst")
    public ResponseEntity<DocListShortResponse> getIgstOrdinance() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(IGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/serviceTax")
    public ResponseEntity<DocListShortResponse> getServiceTaxOrdinance() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(serviceTax);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/utgst")
    public ResponseEntity<DocListShortResponse> getUtgstOrdinance() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(UTGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
