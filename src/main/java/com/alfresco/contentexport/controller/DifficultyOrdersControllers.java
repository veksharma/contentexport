package com.alfresco.contentexport.controller;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.dto.DocListShortResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/difficultyOrders")
public class DifficultyOrdersControllers {

    public static final String CGST= "685262f0-e110-4497-813e-900a96883c88";
    public static final String compensation= "ad238a6d-6a96-4708-9fb5-70b46ccc929b";
    public static final String customsFolder= "1213734c-3085-4d78-97df-6a59188c8601";
    public static final String excise= "160e3429-6866-417e-ae86-696494e39968";
    public static final String IGST= "57f90a5c-90a7-470a-9399-e396eaa52722";
    public static final String serviceTax= "21888c9f-7b80-4ca3-a864-f2656f96b006";
    public static final String SVLDRS= "3b2336aa-837c-40a0-a03f-6ecc861918de";
    public static final String UTGST= "5c5f6af3-91f2-4672-a307-463d8261fb8e";

    private final AlfrescoClient alfrescoClient;

    public DifficultyOrdersControllers(AlfrescoClient alfrescoClient) {
        this.alfrescoClient = alfrescoClient;
    }

    @GetMapping("/cgst")
    public ResponseEntity<DocListShortResponse> getCgstOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(CGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/compensation")
    public ResponseEntity<DocListShortResponse> getCompensationOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(compensation);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/customsFolder")
    public ResponseEntity<DocListShortResponse> getCustomsFolderOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(customsFolder);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/excise")
    public ResponseEntity<DocListShortResponse> getExciseOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(excise);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/igst")
    public ResponseEntity<DocListShortResponse> getIgstOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(IGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/serviceTax")
    public ResponseEntity<DocListShortResponse> getServiceTaxOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(serviceTax);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/svldrs")
    public ResponseEntity<DocListShortResponse> getSvldrsOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(SVLDRS);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

    @GetMapping("/utgst")
    public ResponseEntity<DocListShortResponse> getUtgstOrderTradeNotice() {
        ResponseEntity<DocListShortResponse> response =
                alfrescoClient.getFolderChildrenAsDocList(UTGST);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }

}
