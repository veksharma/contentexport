package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1/gstActs")
public class GstActsController {


    public static final String gstActsPlan  = "a432e639-e5c7-496d-8747-ada4bbfb3098";

    private final AlfrescoClient alfrescoClient;
    public GstActsController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }


@GetMapping("/gstActsPlan")
public Map<String, Object> gstActsPlan() {

    DocListShortResponse sections =
            alfrescoClient.getFolderChildrenAsDocList(gstActsPlan).getBody();

    List<Map<String, Object>> result = new ArrayList<>();

    if (sections != null && sections.getItems() != null) {

        for (DocListShortResponse.DocListItem section : sections.getItems()) {

            DocListShortResponse children =
                    alfrescoClient.getFolderChildrenAsDocList(
                                    section.getNodeRef())
                            .getBody();

            Map<String, Object> node = new HashMap<>();
            node.put("section", section);
            node.put("children",
                    children != null ? children.getItems() : new ArrayList<>());

            result.add(node);
        }
    }

    return Map.of("sections", result);
}


}
