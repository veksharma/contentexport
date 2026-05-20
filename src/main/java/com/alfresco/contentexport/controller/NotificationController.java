package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListResponse;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    public static final String EXCISE = "74394101-0e23-4eed-95e3-b35362f8ea6c";
    public static final String serviceTax= "e7d4e84a-3fa3-49bf-9d7b-b602bdaa6ab1";
    public static final String customsFolder= "e17b08af-96f7-4947-9ab7-ddf50f20dcd4";
    public static final String CGST= "558e42f1-a43a-43c0-9d64-b0c673a03112";
    public static final String IGST= "c68bba24-baed-47f0-8576-af8fbc22c02a";
    public static final String UTGST= "91bded29-56f4-42de-9df8-d03e5b222cfb";
    public static final String compensation= "ac9fc64d-95cb-4768-99bb-742e145ee144";
    public static final String GSTAT = "fc9142f8-2de1-4803-a691-e014025c6cc4";
    public static final String SVLDRS= "6b5dbcbc-939f-4ba9-8565-b9c3cb702170";
    public static final String customsNtcaadri= "52db44ae-f3ad-4d1c-8cb9-1bd9b521404b";
    public static final String SERVICE_TAX = "e7d4e84a-3fa3-49bf-9d7b-b602bdaa6ab1";
    private final AlfrescoClient alfrescoClient;

    public NotificationController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/excise")
    public ResponseEntity<DocListShortResponse> getExciseNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(EXCISE);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/serviceTax")
    public ResponseEntity<DocListShortResponse> getServiceTaxNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(serviceTax);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/customsFolder")
    public ResponseEntity<DocListShortResponse> getCustomsFolderNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customsFolder);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/cgst")
    public ResponseEntity<DocListShortResponse> getCgstNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(CGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/igst")
    public ResponseEntity<DocListShortResponse> getIgstNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(IGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/utgst")
    public ResponseEntity<DocListShortResponse> getUtgstNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(UTGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/compensation")
    public ResponseEntity<DocListShortResponse> getCompensationNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(compensation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/gstat")
    public ResponseEntity<DocListShortResponse> getGstatNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(GSTAT);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/svldrs")
    public ResponseEntity<DocListShortResponse> getSvldrsNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(SVLDRS);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/customsNtcaadri")
    public ResponseEntity<DocListShortResponse> getCustomsNtcaadriNotifications() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customsNtcaadri);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    //http://localhost:8080/api/v1/alfresco/nodes/1a0b110f-1e09-4ca2-b367-fe25e4964a4e/content
    @GetMapping("/download/{nodeId}")
    public ResponseEntity<byte[]> downloadContent(@PathVariable String nodeId) {
        ResponseEntity<byte[]> response = alfrescoClient.getNodeContent(nodeId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(
                ContentDisposition.attachment()
                        .filename(nodeId)
                        .build()
        );

        return new ResponseEntity<>(
                response.getBody(),
                headers,
                response.getStatusCode()
        );
    }

    @GetMapping("/service-tax")
    public ResponseEntity<DocListResponse> getServiceNotifications() {
        ResponseEntity<DocListResponse> response =
                alfrescoClient.getFolderChildrenList(SERVICE_TAX);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}