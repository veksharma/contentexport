package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
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
@RequestMapping(value="/api/v1/gstPropLegislation", produces = MediaType.APPLICATION_JSON_VALUE)
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

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(
                ContentDisposition.attachment()
                        .filename(gstPropLegislation)
                        .build()
        );


        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
