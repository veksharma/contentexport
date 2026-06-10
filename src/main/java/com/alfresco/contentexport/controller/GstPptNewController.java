package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstPpt")
public class GstPptNewController {

    public static final String gstPpt = "d7d6a0fe-e587-4926-bb85-e4cd36cd0493";

    private final AlfrescoClient alfrescoClient;
    public GstPptNewController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstPptNew")
    public ResponseEntity<DocListShortResponse> getGstPptNew() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(gstPpt);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
