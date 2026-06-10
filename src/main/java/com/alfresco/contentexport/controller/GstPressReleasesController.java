package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstPress")
public class GstPressReleasesController {
    public static final String gstPressReleases= "f6944392-40dd-4f9e-8540-34bb34dec6da";

    private final AlfrescoClient alfrescoClient;

    public GstPressReleasesController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
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
