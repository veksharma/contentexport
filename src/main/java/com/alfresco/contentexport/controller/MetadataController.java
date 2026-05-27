package com.alfresco.contentexport.controller;


import com.alfresco.contentexport.service.AlfrescoMetadataService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class MetadataController {

    private final AlfrescoMetadataService alfrescoMetadataService;

    public MetadataController(AlfrescoMetadataService alfrescoMetadataService) {
        this.alfrescoMetadataService = alfrescoMetadataService;
    }

    /**
     * Converts Alfresco XML metadata response into JSON.
     * <p>
     * Example:
     * GET /api/v1/alfresco/nodes/07c6038f-e154-4836-9609-e7ae85300582/metadata-json
     */
    @GetMapping(value = "notification/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getNotificationNodeMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getNotificationNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "circular/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCircularNodeMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getCircularNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "clarification/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getClarificationNodeMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getClarificationNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstStateRelease/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstStateReleaseNodeMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstStateReleaseNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstOrdinance/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstOrdinanceNodeMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstOrdinanceNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "OrderTradeNotice/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrderTradeNoticeMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getOrderTradeNoticeNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "difficultyOrders/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDifficultyOrdersMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getDifficultyOrdersNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstPressRelease/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstPressReleaseNodeMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstPressReleaseNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstRateNotification/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstRateNotificationMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstRateNotificationMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "form/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFormMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getFormMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstActs/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstActsMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstActsMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstRules/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstRulesMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstRulesMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstStateRules/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstStateRulesMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstStateRulesMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/fullmetadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> fullMetadata(@PathVariable String nodeId) {
        Map<String, Object> response = alfrescoMetadataService.fullMetadata(nodeId);
        return ResponseEntity.ok(response);
    }
}