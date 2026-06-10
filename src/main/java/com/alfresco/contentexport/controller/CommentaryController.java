package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/commentary")
public class CommentaryController {

    public static final String lawProcedure = "a5963578-d544-4b32-af08-22b7b22cad95";
    public static final String taxableService = "b1a12ffd-ee67-40bd-ae50-9d2b713a265a";
    public static final String tdsTcs = "58ebacc0-a634-4b46-8751-0c5977d5ab4b";

    private final AlfrescoClient alfrescoClient;
    public CommentaryController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/lawProcedure")
    public ResponseEntity<DocListShortResponse> getLawProcedure() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(lawProcedure);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/taxableService")
    public ResponseEntity<DocListShortResponse> getTaxableService() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(taxableService);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/tdsTcs")
    public ResponseEntity<DocListShortResponse> getTdsTcs() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(tdsTcs);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
