//package com.alfresco.contentexport.controller;
//
//import com.alfresco.contentexport.service.AlfrescoPagedDoclibService;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/alfresco")
//public class AlfrescoPagedDoclibController {
//
//    private final AlfrescoPagedDoclibService alfrescoPagedDoclibService;
//
//    public AlfrescoPagedDoclibController(AlfrescoPagedDoclibService alfrescoPagedDoclibService) {
//        this.alfrescoPagedDoclibService = alfrescoPagedDoclibService;
//    }
//
//    @GetMapping(
//            value = "/folders/{folderNodeId}/children/paged",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<String> getPagedChildren(
//            @PathVariable String folderNodeId,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "100") int size
//    ) {
//        String response = alfrescoPagedDoclibService.getPagedChildren(folderNodeId, page, size);
//
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(response);
//    }
//}