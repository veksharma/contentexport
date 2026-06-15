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


    @GetMapping(value = "gstCaseLaws/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstCaseLawsMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstCaseLawsMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "form/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFormMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getFormMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/draftForms/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDraftFormsMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getDraftFormsMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/stateDraftForms/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStateDraftFormsMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getStateDraftFormsMetadataAsJson(nodeId);
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

    @GetMapping(value = "insolvency/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getInsolvencyNodeMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getInsolvencyNodeMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "incomeTaxAmendmentByFinanceAct/metadata/{nodeId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getIncomeTaxAmendmentByFinanceActMetadataAsJson(
            @PathVariable String nodeId) {

        String response = alfrescoMetadataService
                .getIncomeTaxAmendmentByFinanceActMetadataAsJson(nodeId);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstStateRules/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstStateRulesMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstStateRulesMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstStateLegis/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstStateLegisMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstStateLegisMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "customAct/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomActMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getCustomActMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "customRules/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomRulesMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getCustomRulesMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "financeAct/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFinanceActMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getFinanceActMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "customRegulation/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomRegulationMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getCustomRegulationMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstTariff/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstTariffMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstTariffMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstPptNew/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPptNewMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstPptNewMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstExperts/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstExpertsMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstExpertsMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstInternationalExperts/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstInternationalExpertsMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstInternationalExpertsMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstDeloitteExperts/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstDeloitteExpertsMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstDeloitteExpertsMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "commentary/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCommentaryMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getCommentaryMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "article/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getArticleMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getArticleMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstQA/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstQAMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstQAMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "vatReadyReckoner/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getVatReadyReckonerMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getVatReadyReckonerMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstRcm/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstRcmMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstRcmMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstReferencerGoodsService/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstReferencerGoodsServiceMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstReferencerGoodsServiceMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstReferencerAudit/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstReferencerAuditMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstReferencerAuditMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "gstAuditChecklist/metadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGstAuditChecklistMetadataAsJson(@PathVariable String nodeId) {
        String response = alfrescoMetadataService.getGstAuditChecklistMetadataAsJson(nodeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/fullmetadata/{nodeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> fullMetadata(@PathVariable String nodeId) {
        Map<String, Object> response = alfrescoMetadataService.fullMetadata(nodeId);
        return ResponseEntity.ok(response);
    }
}