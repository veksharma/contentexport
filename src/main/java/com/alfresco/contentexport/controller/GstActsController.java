package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstPropLegislation")
public class GstActsController {

    public static final String gstPropLegislation = "a432e639-e5c7-496d-8747-ada4bbfb3098";

    private final AlfrescoClient alfrescoClient;
    public GstActsController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstPropLegislation")
    public ResponseEntity<DocListShortResponse> getGstPropLegislation() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstPropLegislation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
