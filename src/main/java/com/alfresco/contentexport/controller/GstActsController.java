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

//    public static final String igstJkActNode  = "8a3dd2e8-e439-4837-b5f0-0a0d7b32ce55";
//    public static final String cgstJkActNode = "477b0e02-9cf9-4bd0-b4c4-9addda3460e1";
//    public static final String cgstAct2017Node = "5c24130a-8a28-418d-bffe-b74c2e47c29a";
//    public static final String amendmentActNode = "76a9a35d-5360-4138-9060-f44dad7f3e75";
//    public static final String amendmentBillNode = "0be68ce4-2b1c-4faf-9000-40c150d812d7";
//    public static final String gstCompensationActNode = "e029d6d8-55b9-4e55-bbfa-1ad1f63e0560";
//    public static final String igstAct2017Node = "0314c1c4-065e-48b2-929e-f2f33055c350";
//    public static final String utgstAct2017Node  = "efc48899-9e19-4a30-9d39-68974d34c539";

    public static final String gstActsPlan  = "a432e639-e5c7-496d-8747-ada4bbfb3098";

    private final AlfrescoClient alfrescoClient;
    public GstActsController(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

//    @GetMapping("/igstJkActNode")
//    public ResponseEntity<DocListShortResponse> getIgstJkActNode() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(igstJkActNode);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cgstJkActNode")
//    public ResponseEntity<DocListShortResponse> getcgstJkActNode() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cgstJkActNode);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//
//    @GetMapping("/cgstAct2017Node")
//    public ResponseEntity<DocListShortResponse> getGgstAct2017Node() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(cgstAct2017Node);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//    @GetMapping("/amendmentActNode")
//    public ResponseEntity<DocListShortResponse> getGstAmendmentActNode() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(amendmentActNode);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//    @GetMapping("/amendmentBillNode")
//    public ResponseEntity<DocListShortResponse> getGstAmendmentBillNode() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(amendmentBillNode);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//    @GetMapping("/gstCompensationActNode")
//    public ResponseEntity<DocListShortResponse> getGstCompensationActNode() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(gstCompensationActNode);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//    @GetMapping("/igstAct2017Node")
//    public ResponseEntity<DocListShortResponse> getGstAct2017Node() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(igstAct2017Node);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
//    @GetMapping("/utgstAct2017Node")
//    public ResponseEntity<DocListShortResponse> getUtgstAct2017Node() {
//        ResponseEntity<DocListShortResponse> response =
//                alfrescoClient.getFolderChildrenAsDocList(utgstAct2017Node);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }

//    -----------------------------
@GetMapping("/gstActsTree")
public Map<String, Object> getGstActsTree() {

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
