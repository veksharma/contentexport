package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gstCouncilMeeting")
public class GstCouncilMeetingController {

    public static final String GST_COUNCIL_MEETING_FOLDER_ID =
            "e5447967-c2fc-4d6d-9efd-c9871e88e3ac";

    private final AlfrescoClient alfrescoClient;

    public GstCouncilMeetingController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/gstCouncilMeeting")
    public ResponseEntity<DocListShortResponse> getGstCouncilMeeting() {

        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(
                        GST_COUNCIL_MEETING_FOLDER_ID);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}