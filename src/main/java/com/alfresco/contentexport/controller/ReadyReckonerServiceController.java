package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/readyReckonerService")
public class ReadyReckonerServiceController {

    public static final String READY_RECKONER_SERVICETAX_FOLDER_ID =
            "79f30fdf-9c0b-4698-a23f-f77fdca1034c";

    private final AlfrescoClient alfrescoClient;

    public ReadyReckonerServiceController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/readyReckonerService")
    public ResponseEntity<DocListShortResponse> getReadyReckonerService() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(
                        READY_RECKONER_SERVICETAX_FOLDER_ID);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}