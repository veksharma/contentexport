package com.alfresco.contentexport.controller;


import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstPressRelease")
public class GstStateRelease {

    public static final String circular= "efd0abd3-14cd-48ad-a45a-355217f6b3cc";
    public static final String clarifications= "02018466-7bab-4b0b-8481-28a3aa72b4aa";
    public static final String forms= "aaa4a582-5deb-4d5d-a137-639a8c775c70";
    public static final String notification= "2da3864f-bb50-4a1f-a09b-cc6c1389836c";
    public static final String order= "4dbe14a1-7bca-46c9-97f6-5001e3be65bb";


    private final AlfrescoClient alfrescoClient;

    public GstStateRelease(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/circular")
    public ResponseEntity<DocListShortResponse> getCircularGstPress() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(circular);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/clarifications")
    public ResponseEntity<DocListShortResponse> getClarificationsGstPress() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(clarifications);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/forms")
    public ResponseEntity<DocListShortResponse> getFormsGstPress() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(forms);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/notification")
    public ResponseEntity<DocListShortResponse> getNotificationGstPress() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(notification);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/order")
    public ResponseEntity<DocListShortResponse> getOrderGstPress() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(order);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
