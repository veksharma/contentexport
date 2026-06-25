package com.alfresco.contentexport.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlfrescoMetadataService {

    private final RestTemplate restTemplate;

    @Value("${alfresco.base-url}")
    private String alfrescoBaseUrl;

    @Value("${alfresco.username}")
    private String alfrescoUsername;

    @Value("${alfresco.password}")
    private String alfrescoPassword;

    private static final Logger log = LoggerFactory.getLogger(AlfrescoMetadataService.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public AlfrescoMetadataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> fullMetadata(String nodeId) {
        log.info("Fetching fullMetadata for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return stringObjectMap;
    }

    public String getNotificationNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessNotificationMetaData(stringObjectMap, nodeId);
    }

    public String getCircularNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessCircularMetaData(stringObjectMap, nodeId);
    }

    public String getClarificationNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessClarificationMetaData(stringObjectMap, nodeId);
    }

    public String getGstStateReleaseNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstStateReleaseMetaData(stringObjectMap, nodeId);
    }

    public String getGstOrdinanceNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstOrdinanceMetaData(stringObjectMap, nodeId);
    }

    public String getOrderTradeNoticeNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessOrderTradeNoticeMetaData(stringObjectMap, nodeId);
    }

    public String getDifficultyOrdersNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessDifficultyOrdersMetaData(stringObjectMap, nodeId);
    }

    public String getGstPressReleaseNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstPressReleaseMetaData(stringObjectMap, nodeId);
    }

    public String getInsolvencyNodeMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessInsolvencyMetaData(stringObjectMap, nodeId);
    }

    public String getIncomeTaxAmendmentByFinanceActMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessIncomeTaxAmendmentByFinanceActMetadata(stringObjectMap, nodeId);
    }

    public String getGstRateNotificationMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstRateNotificationMetaData(stringObjectMap, nodeId);
    }

    public String getGstCaseLawsMetadataAsJson(String nodeId) {
        log.info("Fetching getGstCaseLawsMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstCaseLawsMetaData(stringObjectMap, nodeId);
    }

    public String getStCaseLawsMetadataAsJson(String nodeId) {
        log.info("Fetching getStCaseLawsMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessStCaseLawsMetaData(stringObjectMap, nodeId);
    }


    public String getFormMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessFormMetaData(stringObjectMap, nodeId);
    }

    public String getDraftFormsMetadataAsJson(String nodeId) {
        log.info("Fetching getDraftFormsMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessDraftFormsMetaData(stringObjectMap, nodeId);
    }

    public String getStateDraftFormsMetadataAsJson(String nodeId) {
        log.info("Fetching getStateDraftFormsMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessStateDraftFormsMetaData(stringObjectMap, nodeId);
    }

    public String getGstGoodsOrderInstructionMetadataAsJson(String nodeId) {
        log.info("Fetching getGstGoodsOrderInstructionMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstGoodsOrderInstructionMetaData(stringObjectMap, nodeId);
    }


    public String getGstActsMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstActsMetaData(stringObjectMap, nodeId);
    }

    public String getGstRulesMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstRulesMetaData(stringObjectMap, nodeId);
    }


    public String getGstStateRulesMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstStateRulesMetaData(stringObjectMap, nodeId);
    }

    public String getGstStateLegisMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstStateRulesLegisMetaData(stringObjectMap, nodeId);
    }

    public String getCustomActMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessCustomActMetaData(stringObjectMap, nodeId);
    }

    public String getCustomRulesMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessCustomRulesMetaData(stringObjectMap, nodeId);
    }

    public String getFinanceActMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessFinanceActMetaData(stringObjectMap, nodeId);
    }

    public String getCustomRegulationMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessCustomRegulationMetaData(stringObjectMap, nodeId);
    }

    public String getGstTariffMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstTariffMetaData(stringObjectMap, nodeId);
    }

    public String getGstPptNewMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstPptNewMetaData(stringObjectMap, nodeId);
    }

    public String getGstCouncilMeetingMetadataAsJson(String nodeId) {
        log.info("Fetching getGstCouncilMeetingMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstCouncilMeetingMetaData(stringObjectMap, nodeId);
    }

    public String getReadyReckonerServiceMetadataAsJson(String nodeId) {
        log.info("Fetching getReadyReckonerServiceMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessReadyReckonerServiceMetaData(stringObjectMap, nodeId);
    }

    public String getReadyReckonerGoodsServiceMetadataAsJson(String nodeId) {
        log.info("Fetching getReadyReckonerGoodsServiceMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessReadyReckonerGoodsServiceMetaData(stringObjectMap, nodeId);
    }

    public String getGstCommentaryMetadataAsJson(String nodeId) {
        log.info("Fetching getGstCommentaryMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstCommentaryMetaData(stringObjectMap, nodeId);
    }



    public String getGstExpertsMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstExpertsAnalysisMetaData(stringObjectMap, nodeId);
    }


    public String getGstInternationalExpertsMetadataAsJson(String nodeId) {
        log.info("Fetching getGstInternationalExpertsMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstInternationalExpertsMetaData(stringObjectMap, nodeId);
    }

    public String getGstDeloitteExpertsMetadataAsJson(String nodeId) {
        log.info("Fetching getGstDeloitteExpertsMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstDeloitteExpertsMetaData(stringObjectMap, nodeId);
    }


    public String getCommentaryMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLesscommentaryMetaData(stringObjectMap, nodeId);
    }

    public String getArticleMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessArticleMetaData(stringObjectMap, nodeId);
    }

    public String getGstQAMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstQAMetaData(stringObjectMap, nodeId);
    }

    public String getVatReadyReckonerMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessVatReadyReckonerMetaData(stringObjectMap, nodeId);
    }

    public String getGstRcmMetadataAsJson(String nodeId) {
        log.info("Fetching getNodeMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstRcmReckonerMetaData(stringObjectMap, nodeId);
    }

    private String getLessGstReferencerGoodsServiceMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Author", properties.get("sTaxGSTReferencer:author"));
            response.put("Citation", properties.get("sTaxGSTReferencer:citation"));
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            log.error("exception", e);
            return """
            {
              "error": "Failed to GST Referencer Goods Service summary"
            }
            """;
        }
    }

    private String getLessGstReferencerAuditMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Author", properties.get("sTaxGSTReferencer:author"));
            response.put("Citation", properties.get("sTaxGSTReferencer:citation"));
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            log.error("exception", e);
            return """
        {
          "error": "Failed to GST Referencer Audit summary"
        }
        """;
        }
    }


    private String getLessGstAuditChecklistMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            log.error("exception", e);
            return """
        {
          "error": "Failed to GST Audit Checklist summary"
        }
        """;
        }
    }


    private String getLessNotificationMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxNotification:subject"));
            response.put("StaxNotificationDate", properties.get("sTaxNotification:sTaxNotificationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch notification summary"
                }
                """;
        }
    }

    private String getLessInsolvencyMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Description", properties.get("cm:description"));
            response.put("Subject", properties.get("dTaxNotificationInsolvency:subject"));
            response.put("Notification Date", properties.get("dTaxNotificationInsolvency:dTaxNotificationDate"));
            response.put("Circular Date", properties.get("dTaxCircularInsolvency:dTaxCircularDate"));
            response.put("Circular Subject", properties.get("dTaxCircularInsolvency:subject"));



            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Insolvency summary"
                }
                """;
        }
    }



    private String getLessIncomeTaxAmendmentByFinanceActMetadata(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("dTaxAmendedFinanceAct:topicName"));
            response.put("IncomeTaxDate", properties.get("dTaxAmendedFinanceAct:topicDate"));
            response.put("Preliminary", properties.get("dTaxAmendedFinanceAct:topicPreliminary"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Income Tax summary"
                }
                """;
        }
    }


    private String getLessCircularMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxCircular:subject"));
            response.put("StaxNotificationDate", properties.get("sTaxCircular:sTaxCircularDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Circular summary"
                }
                """;
        }
    }

    private String getLessGstStateReleaseMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("State Release Circular States", properties.get("sTaxGSTCircular:states"));
            response.put("State release Circular Subject", properties.get("sTaxGSTCircular:subject"));
            response.put("State release Circular Date", properties.get("sTaxGSTCircular:circularDate"));
            response.put("State release Clarification Subject", properties.get("sTaxClarification:subject"));
            response.put("State release Clarification Date", properties.get("sTaxClarification:sTaxClarificationDate"));
            response.put("State Release notification States", properties.get("sTaxGSTNotification:states"));
            response.put("State release notification Subject", properties.get("sTaxGSTNotification:subject"));
            response.put("State release notification Date", properties.get("sTaxGSTNotification:notificationDate"));
            response.put("State Release order States", properties.get("sTaxGSTInstruction:states"));
            response.put("State release order Subject", properties.get("sTaxGSTInstruction:subject"));
            response.put("State release order Date", properties.get("sTaxGSTInstruction:OrderTradeNotificationDate"));
            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst-State-Release summary"
                }
                """;
        }
    }

    private String getLessGstOrdinanceMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxGSTNotification:subject"));
            response.put("StaxNotificationDate", properties.get("sTaxGSTNotification:notificationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst Ordinance summary"
                }
                """;
        }
    }

    private String getLessClarificationMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxClarification:subject"));
            response.put("StaxNotificationDate", properties.get("sTaxClarification:sTaxClarificationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Clarification summary"
                }
                """;
        }
    }

    private String getLessDifficultyOrdersMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxOrderTradeNoticeInstruction:subject"));
            response.put("StaxNotificationDate", properties.get("sTaxOrderTradeNoticeInstruction:sTaxOrderTradeNoticeInstructionDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Difficulty Orders summary"
                }
                """;
        }
    }

    private String getLessOrderTradeNoticeMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxOrderTradeNoticeInstruction:subject"));
            response.put("StaxNotificationDate", properties.get("sTaxOrderTradeNoticeInstruction:sTaxOrderTradeNoticeInstructionDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Order Trade Notice summary"
                }
                """;
        }
    }

    private String getLessFormMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("cm:description"));
            response.put("StaxNotificationDate", properties.get("sTaxGSTPressReleases:sTaxGSTPressReleasesDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Forms summary"
                }
                """;
        }
    }

    private String getLessDraftFormsMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("cm:description"));
            response.put("StaxNotificationDate", properties.get("sTaxGSTPressReleases:sTaxGSTPressReleasesDate"));
            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
            {
              "error": "Failed to fetch Draft Forms summary"
            }
            """;
        }
    }


    private String getLessStateDraftFormsMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties = (Map<String, Object>) fullMetadata.get("properties");
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("cm:description"));
            response.put("sTaxDraftFormsDate", properties.get("sTaxDraftForms:sTaxDraftFormsDate"));
            response.put("pnID", properties.get("sTaxDraftForms:pnID"));
            response.put("formTopic", properties.get("sTaxDraftForms:formTopic"));
            response.put("formNo", properties.get("sTaxDraftForms:formNo"));
            response.put("formName", properties.get("sTaxDraftForms:formName"));
            response.put("states", properties.get("sTaxDraftForms:states"));
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            log.error("exception", e);
            return """
        {
          "error": "Failed to fetch State Draft Forms summary"
        }
        """;
        }
    }


    private String getLessGstGoodsOrderInstructionMetaData(
            Map<String, Object> fullMetadata,
            String nodeId) {

        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();

            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("description", properties.get("cm:description"));
            response.put("OrderTradeNotificationDate", properties.get("sTaxGSTInstruction:OrderTradeNotificationDate"));
            response.put("subject", properties.get("sTaxGSTInstruction:subject"));
            response.put("pnID", properties.get("sTaxGSTInstruction:pnID"));
            response.put("orderNo", properties.get("sTaxGSTInstruction:orderNo"));
            response.put("topic", properties.get("sTaxGSTInstruction:topic"));
            response.put("states", properties.get("sTaxGSTInstruction:states"));
            response.put("citation", properties.get("sTaxGSTInstruction:citation"));
            response.put("fileNo", properties.get("sTaxGSTInstruction:fileNo"));
            response.put("section", properties.get("sTaxGSTInstruction:section"));
            response.put("year", properties.get("sTaxGSTInstruction:year"));
            response.put("topicPnID", properties.get("sTaxGSTInstruction:topicPnID"));
            response.put("topicName", properties.get("sTaxGSTInstruction:topicName"));
            response.put("topicContent", properties.get("sTaxGSTInstruction:topicContent"));
            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);

            return """
        {
          "error": "Failed to fetch GST Goods Order Instruction summary"
        }
        """;
        }
    }


    private String getLessGstRateNotificationMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("cm:description"));
            response.put("StaxNotificationDate", properties.get("sTaxGSTTariff:notificationDate"));
            response.put("StaxRelatedAnalysis", properties.get("sTaxGSTTariff:relatedAnalysisNew"));
            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst Tariff summary"
                }
                """;
        }
    }


    private String getLessGstCaseLawsMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxGSTCaseLaws:subject"));
            response.put("States", properties.get("sTaxGSTCaseLaws:states"));
            response.put("counselAppeared", properties.get("sTaxGSTCaseLaws:counselAppeared"));
            response.put("decisionInFavourOf", properties.get("sTaxGSTCaseLaws:decisionInFavourOf"));
            response.put("casePertainsTo", properties.get("sTaxGSTCaseLaws:casePertainsTo"));
            response.put("NotificationsReferredTo", properties.get("sTaxGSTCaseLaws:NotificationsReferredTo"));
            response.put("CircularsReferredTo", properties.get("sTaxGSTCaseLaws:CircularsReferredTo"));
            response.put("legislationReferredTo", properties.get("sTaxGSTCaseLaws:legislationReferredTo"));
            response.put("equivalentCitation", properties.get("sTaxGSTCaseLaws:equivalentCitation"));
            response.put("cchCitation", properties.get("sTaxGSTCaseLaws:cchCitation"));
            response.put("caseLawsDate", properties.get("sTaxGSTCaseLaws:caseLawsDate"));
            response.put("sections", properties.get("sTaxGSTCaseLaws:sections"));
            response.put("backwardReference", properties.get("sTaxGSTCaseLaws:backwardReference"));
            response.put("forwardReference", properties.get("sTaxGSTCaseLaws:forwardReference"));
            response.put("pnID", properties.get("sTaxGSTCaseLaws:pnID"));
            response.put("caseNumber", properties.get("sTaxGSTCaseLaws:caseNumber"));
            response.put("judge", properties.get("sTaxGSTCaseLaws:judge"));
            response.put("specialBenchname", properties.get("sTaxGSTCaseLaws:specialBenchname"));
            response.put("benchName", properties.get("sTaxGSTCaseLaws:benchName"));
            response.put("court", properties.get("sTaxGSTCaseLaws:court"));
            response.put("respondant", properties.get("sTaxGSTCaseLaws:respondant"));
            response.put("appellant", properties.get("sTaxGSTCaseLaws:appellant"));
            response.put("caseReferredTo", properties.get("sTaxGSTCaseLaws:caseReferredTo"));
            response.put("pronouncedByJudge", properties.get("sTaxGSTCaseLaws:pronouncedByJudge"));
            response.put("pronouncedByOthers", properties.get("sTaxGSTCaseLaws:pronouncedByOthers"));
            response.put("gstServices", properties.get("sTaxGSTCaseLaws:gstServices"));
            response.put("gstIndustries", properties.get("sTaxGSTCaseLaws:gstIndustries"));
            response.put("gstGoods", properties.get("sTaxGSTCaseLaws:gstGoods"));
            response.put("catchWord", properties.get("sTaxGSTCaseLaws:catchWord"));
            response.put("conclusion", properties.get("sTaxGSTCaseLaws:conclusion"));
            response.put("inFavourOf", properties.get("sTaxGSTCaseLaws:inFavourOf"));
            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
            {
              "error": "Failed to fetch GST Case Laws summary"
            }
            """;
        }
    }

    private String getLessStCaseLawsMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxCaseLaws:stSubject"));
            response.put("counselAppeared", properties.get("sTaxCaseLaws:counselAppeared"));
            response.put("decisionInFavourOf", properties.get("sTaxCaseLaws:decisionInFavourOf"));
            response.put("casePertainsTo", properties.get("sTaxCaseLaws:casePertainsTo"));
            response.put("NotificationsReferredTo", properties.get("sTaxCaseLaws:NotificationsReferredTo"));
            response.put("CircularsReferredTo", properties.get("sTaxCaseLaws:CircularsReferredTo"));
            response.put("legislationReferredTo", properties.get("sTaxCaseLaws:legislationReferredTo"));
            response.put("equivalentCitation", properties.get("sTaxCaseLaws:equivalentCitation"));
            response.put("cchCitation", properties.get("sTaxCaseLaws:cchCitation"));
            response.put("caseLawsDate", properties.get("sTaxCaseLaws:caseLawsDate"));
            response.put("sections", properties.get("sTaxCaseLaws:sections"));
            response.put("backwardReference", properties.get("sTaxCaseLaws:backwardReference"));
            response.put("forwardReference", properties.get("sTaxCaseLaws:forwardReference"));
            response.put("pnID", properties.get("sTaxCaseLaws:pnID"));
            response.put("caseNumber", properties.get("sTaxCaseLaws:caseNumber"));
            response.put("judge", properties.get("sTaxCaseLaws:judge"));
            response.put("specialBenchname", properties.get("sTaxCaseLaws:specialBenchname"));
            response.put("benchName", properties.get("sTaxCaseLaws:benchName"));
            response.put("court", properties.get("sTaxCaseLaws:court"));
            response.put("respondant", properties.get("sTaxCaseLaws:respondant"));
            response.put("appellant", properties.get("sTaxCaseLaws:appellant"));
            response.put("caseReferredTo", properties.get("sTaxCaseLaws:caseReferredTo"));
            response.put("pronouncedByJudge", properties.get("sTaxCaseLaws:pronouncedByJudge"));
            response.put("pronouncedByOthers", properties.get("sTaxCaseLaws:pronouncedByOthers"));
            response.put("serviceCategory", properties.get("sTaxCaseLaws:serviceCategory"));
            response.put("landmarkCases", properties.get("sTaxCaseLaws:landmarkCases"));
            response.put("notificationReferredTo", properties.get("sTaxCaseLaws:notificationReferredTo"));
            response.put("circularReferredTo", properties.get("sTaxCaseLaws:circularReferredTo"));
            response.put("rules", properties.get("sTaxCaseLaws:rules"));
            response.put("catchWord", properties.get("sTaxCaseLaws:catchWord"));
            response.put("conclusion", properties.get("sTaxCaseLaws:conclusion"));
            response.put("inFavourOf", properties.get("sTaxCaseLaws:inFavourOf"));
            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
        {
          "error": "Failed to fetch ST Case Laws summary"
        }
        """;
        }
    }


    private String getLessGstActsMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("cm:description"));
            response.put("pnID", properties.get("sTaxGSTProposedLegislations:pnID"));
            response.put("chapterNo", properties.get("sTaxGSTProposedLegislations:chapterNo"));
            response.put("chapterBody", properties.get("sTaxGSTProposedLegislations:chapterBody"));
            response.put("chapterName", properties.get("sTaxGSTProposedLegislations:chapterName"));
            response.put("sectionNoHTML", properties.get("sTaxGSTProposedLegislations:sectionNoHTML"));
            response.put("sectionNo", properties.get("sTaxGSTProposedLegislations:sectionNo"));
            response.put("sectionName", properties.get("sTaxGSTProposedLegislations:sectionName"));
            response.put("sectionNameHTML", properties.get("sTaxGSTProposedLegislations:sectionNameHTML"));
            response.put("subSectionNo", properties.get("sTaxGSTProposedLegislations:subSectionNo"));
            response.put("NotificationList", properties.get("sTaxGSTProposedLegislations:NotificationList"));
            response.put("subSectionBody", properties.get("sTaxGSTProposedLegislations:subSectionBody"));
            response.put("NotificationListHTML", properties.get("sTaxGSTProposedLegislations:NotificationListHTML"));
            response.put("subSectionNoHTML", properties.get("sTaxGSTProposedLegislations:subSectionNoHTML"));
            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst Prop Legislation summary"
                }
                """;
        }
    }

    private String getLessGstRulesMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("cm:description"));
            response.put("pnID", properties.get("sTaxRule:pnID"));
            response.put("chapterNo", properties.get("sTaxRule:chapterNo"));
            response.put("chapterBody", properties.get("sTaxRule:chapterBody"));
            response.put("chapterName", properties.get("sTaxRule:chapterName"));
            response.put("chapterNameHTML", properties.get("sTaxRule:chapterName"));
            response.put("ruleNameHTML", properties.get("sTaxRule:ruleNameHTML"));
            response.put("ruleBody", properties.get("sTaxRule:ruleBody"));
            response.put("ruleName", properties.get("sTaxRule:ruleName"));
            response.put("ruleNoHTML", properties.get("sTaxRule:ruleNoHTML"));
            response.put("ruleNo", properties.get("sTaxRule:ruleNo"));
            response.put("NotificationList", properties.get("sTaxRule:NotificationList"));
            response.put("subSectionBody", properties.get("sTaxRule:subSectionBody"));
            response.put("NotificationListHTML", properties.get("sTaxRule:NotificationListHTML"));
            response.put("subSectionNoHTML", properties.get("sTaxRule:subSectionNoHTML"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst Rules summary"
                }
                """;
        }
    }

    private String getLessGstPressReleaseMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxGSTPressReleases:subject"));
            response.put("StaxNotificationDate", properties.get("sTaxGSTPressReleases:sTaxGSTPressReleasesDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst Press Release summary"
                }
                """;
        }
    }

    private String getLessGstStateRulesMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Description", properties.get("cm:description"));
            response.put("sTaxDate", properties.get("sTaxRule:sTaxDate"));
            response.put("states", properties.get("sTaxRule:states"));
            response.put("descriptionHTML", properties.get("sTaxRule:descriptionHTML"));
            response.put("referenceNumber", properties.get("sTaxRule:referenceNumber"));
            response.put("pnID", properties.get("sTaxRule:pnID"));
            response.put("chapterNameHTML", properties.get("sTaxRule:chapterNameHTML"));
            response.put("chapterBody", properties.get("sTaxRule:chapterBody"));
            response.put("chapterName", properties.get("sTaxRule:chapterName"));
            response.put("ruleBody", properties.get("sTaxRule:ruleBody"));
            response.put("ruleNameHTML", properties.get("sTaxRule:ruleNameHTML"));
            response.put("ruleName", properties.get("sTaxRule:ruleName"));
            response.put("ruleNoHTML", properties.get("sTaxRule:ruleNoHTML"));
            response.put("ruleNo", properties.get("sTaxRule:ruleNo"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst state Rules summary"
                }
                """;
        }
    }

    private String getLessGstStateRulesLegisMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Description", properties.get("cm:description"));
            response.put("sTaxDate", properties.get("sTaxGSTProposedLegislations:sTaxDate"));
            response.put("states", properties.get("sTaxGSTProposedLegislations:states"));
            response.put("sTaxActNo", properties.get("sTaxGSTProposedLegislations:sTaxActNo"));
            response.put("pnID", properties.get("sTaxGSTProposedLegislations:pnID"));
            response.put("chapterNo", properties.get("sTaxGSTProposedLegislations:chapterNo"));
            response.put("chapterBody", properties.get("sTaxGSTProposedLegislations:chapterBody"));
            response.put("chapterName", properties.get("sTaxGSTProposedLegislations:chapterName"));
            response.put("sectionNoHTML", properties.get("sTaxGSTProposedLegislations:sectionNoHTML"));
            response.put("sectionNo", properties.get("sTaxGSTProposedLegislations:sectionNo"));
            response.put("sectionName", properties.get("sTaxGSTProposedLegislations:sectionName"));
            response.put("sectionNameHTML", properties.get("sTaxGSTProposedLegislations:sectionNameHTML"));
            response.put("subSectionNo", properties.get("sTaxGSTProposedLegislations:subSectionNo"));
            response.put("NotificationList", properties.get("sTaxGSTProposedLegislations:NotificationList"));
            response.put("subSectionBody", properties.get("sTaxGSTProposedLegislations:subSectionBody"));
            response.put("NotificationListHTML", properties.get("sTaxGSTProposedLegislations:NotificationListHTML"));
            response.put("subSectionNoHTML", properties.get("sTaxGSTProposedLegislations:subSectionNoHTML"));
            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst state Legislation Rules summary"
                }
                """;
        }
    }

    private String getLessCustomActMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Description", properties.get("cm:description"));;
            response.put("Date", properties.get("sTaxSTAct:ruleDate"));
            response.put("States", properties.get("sTaxSTAct:states"));
            response.put("chapterBody", properties.get("sTaxSTAct:chapterBody"));
            response.put("chapterNameHTML", properties.get("sTaxSTAct:chapterNameHTML"));
            response.put("chapterName", properties.get("sTaxSTAct:chapterName"));
            response.put("ruleBody", properties.get("sTaxSTAct:ruleBody"));
            response.put("ruleNameHTML", properties.get("sTaxSTAct:ruleNameHTML"));
            response.put("ruleName", properties.get("sTaxSTAct:ruleName"));
            response.put("ruleNoHTML", properties.get("sTaxSTAct:ruleNoHTML"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Custom Act summary"
                }
                """;
        }
    }

    private String getLessCustomRulesMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Description", properties.get("cm:description"));
            response.put("Subject", properties.get("sTaxSTRule:subject"));
            response.put("ruleDate", properties.get("sTaxRule:ruleDate"));
            response.put("States", properties.get("sTaxSTRule:states"));
            response.put("chapterBody", properties.get("sTaxSTRule:chapterBody"));
            response.put("chapterNameHTML", properties.get("sTaxSTRule:chapterNameHTML"));
            response.put("chapterName", properties.get("sTaxSTRule:chapterName"));
            response.put("ruleBody", properties.get("sTaxSTRule:ruleBody"));
            response.put("ruleNameHTML", properties.get("sTaxSTRule:ruleNameHTML"));
            response.put("ruleName", properties.get("sTaxSTRule:ruleName"));
            response.put("ruleNoHTML", properties.get("sTaxSTRule:ruleNoHTML"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Custom Rules summary"
                }
                """;
        }
    }

    public String getGstReferencerGoodsServiceMetadataAsJson(String nodeId) {
        log.info("Fetching getGstReferencerGoodsServiceMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstReferencerGoodsServiceMetaData(stringObjectMap, nodeId);
    }

    public String getGstReferencerAuditMetadataAsJson(String nodeId) {
        log.info("Fetching getGstReferencerAuditMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstReferencerAuditMetaData(stringObjectMap, nodeId);
    }

    public String getGstAuditChecklistMetadataAsJson(String nodeId) {
        log.info("Fetching getGstAuditChecklistMetadataAsJson for nodeId={}", nodeId);
        String xml = fetchAlfrescoNodeMetadataXml(nodeId);
        Map<String, Object> stringObjectMap = convertAlfrescoXmlToJson(nodeId, xml);
        return getLessGstAuditChecklistMetaData(stringObjectMap, nodeId);
    }

    private String getLessFinanceActMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("sTaxFinanceActYear", properties.get("sTaxFinanceAct:year"));
            response.put("sTaxFinanceActDate", properties.get("sTaxFinanceAct:date"));
            response.put("chapterBody", properties.get("sTaxFinanceAct:chapterBody"));
            response.put("chapterName", properties.get("sTaxFinanceAct:chapterName"));
            response.put("clausePnID", properties.get("sTaxFinanceAct:clausePnID"));
            response.put("clauseNo", properties.get("sTaxFinanceAct:clauseNo"));
            response.put("clauseName", properties.get("sTaxFinanceAct:clauseName"));
            response.put("clauseBody", properties.get("sTaxFinanceAct:clauseBody"));


            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to Finance Act summary"
                }
                """;
        }
    }

    private String getLessCustomRegulationMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Description", properties.get("cm:description"));
            response.put("Date", properties.get("sTaxCRRule:ruleDate"));
            response.put("State", properties.get("sTaxCRRule:states"));
            response.put("chapterNameHTML", properties.get("sTaxCRRule:chapterNameHTML"));
            response.put("chapterName", properties.get("sTaxCRRule:chapterName"));
            response.put("chapterBody", properties.get("sTaxCRRule:chapterBody"));
            response.put("ruleBody", properties.get("sTaxCRRule:ruleBody"));
            response.put("ruleNameHTML", properties.get("sTaxCRRule:ruleNameHTML"));
            response.put("ruleNoHTML", properties.get("sTaxCRRule:ruleNoHTML"));
            response.put("ruleName", properties.get("sTaxCRRule:ruleName"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to Custom Regulation summary"
                }
                """;
        }
    }

    private String getLessGstTariffMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("description", properties.get("cm:description"));
            response.put("Date", properties.get("sTaxTSERule:ruleDate"));
            response.put("States", properties.get("sTaxTSERule:states"));
            response.put("ruleBody", properties.get("sTaxTSERule:ruleBody"));
            response.put("ruleNoHTML", properties.get("sTaxTSERule:ruleNoHTML"));
            response.put("ruleNameHTML", properties.get("sTaxTSERule:ruleNameHTML"));
            response.put("ruleName", properties.get("sTaxTSERule:ruleName"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to GST Tariff summary"
                }
                """;
        }
    }

    private String getLessGstPptNewMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Category", properties.get("dTaxForms:formCategory"));
            response.put("FormNo", properties.get("dTaxForms:formNo"));
            response.put("Description", properties.get("dTaxForms:description"));
            response.put("formDesc", properties.get("dTaxForms:formDesc"));
            response.put("formNo", properties.get("dTaxForms:formNo"));
            response.put("pnID", properties.get("dTaxForms:pnID"));
            response.put("formCategory", properties.get("dTaxForms:formCategory"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch GstPptNew summary"
                }
                """;
        }
    }

    private String getLessGstCouncilMeetingMetaData(
            Map<String, Object> fullMetadata,
            String nodeId) {

        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("publicationDate", properties.get("ifrmArticle:publicationDate"));
            response.put("citation", properties.get("ifrmArticle:citation"));
            response.put("description", properties.get("cm:description"));
            response.put("pnID", properties.get("ifrmArticle:pnID"));
            response.put("subject", properties.get("ifrmArticle:subject"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch GstCouncilMeeting summary"
                }
                """;
        }
    }


    private String getLessReadyReckonerServiceMetaData(
            Map<String, Object> fullMetadata,
            String nodeId) {

        try {
            Map<String, Object> properties = (Map<String, Object>) fullMetadata.get("properties");
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("citation", properties.get("sTaxReadyReckoner:citation"));
            response.put("description", properties.get("cm:description"));
            response.put("pnID", properties.get("sTaxReadyReckoner:pnID"));
            response.put("subject", properties.get("sTaxReadyReckoner:subject"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
            {
              "error": "Failed to fetch ReadyReckonerServicetax summary"
            }
            """;
        }
    }


    private String getLessReadyReckonerGoodsServiceMetaData(
            Map<String, Object> fullMetadata,
            String nodeId) {

        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("citation", properties.get("sTaxEAnalysis:citation"));
            response.put("description", properties.get("cm:description"));
            response.put("pnID", properties.get("sTaxEAnalysis:pnID"));
            response.put("author", properties.get("sTaxEAnalysis:author"));
            response.put("topicContent", properties.get("sTaxEAnalysis:topicContent"));
            response.put("topicPnID", properties.get("sTaxEAnalysis:topicPnID"));
            response.put("topicName", properties.get("sTaxEAnalysis:topicName"));
            response.put("published", properties.get("sTaxEAnalysis:published"));
            response.put("topicNameHTML", properties.get("sTaxEAnalysis:topicNameHTML"));
            response.put("subTopicName", properties.get("sTaxEAnalysis:subTopicName"));
            response.put("subTopicNameHTML", properties.get("sTaxEAnalysis:subTopicNameHTML"));
            response.put("subtopicContent", properties.get("sTaxEAnalysis:subtopicContent"));
            response.put("subject", properties.get("sTaxEAnalysis:subject"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
        {
          "error": "Failed to fetch ReadyReckonerGoodsService summary"
        }
        """;
        }
    }



    private String getLessGstCommentaryMetaData(
            Map<String, Object> fullMetadata,
            String nodeId) {

        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("citation", properties.get("sTaxEAnalysis:citation"));
            response.put("description", properties.get("cm:description"));
            response.put("pnID", properties.get("sTaxEAnalysis:pnID"));
            response.put("author", properties.get("sTaxEAnalysis:author"));
            response.put("topicContent", properties.get("sTaxEAnalysis:topicContent"));
            response.put("topicPnID", properties.get("sTaxEAnalysis:topicPnID"));
            response.put("topicName", properties.get("sTaxEAnalysis:topicName"));
            response.put("published", properties.get("sTaxEAnalysis:published"));
            response.put("topicNameHTML", properties.get("sTaxEAnalysis:topicNameHTML"));
            response.put("subTopicName", properties.get("sTaxEAnalysis:subTopicName"));
            response.put("subTopicNameHTML", properties.get("sTaxEAnalysis:subTopicNameHTML"));
            response.put("subtopicContent", properties.get("sTaxEAnalysis:subtopicContent"));
            response.put("subject", properties.get("sTaxEAnalysis:subject"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
        {
          "error": "Failed to fetch GstCommentary summary"
        }
        """;
        }
    }



    private String getLessGstExpertsAnalysisMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Author", properties.get("sTaxArticle:author"));
            response.put("Publication Date", properties.get("sTaxArticle:publicationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch GST Experts Analysis summary"
                }
                """;
        }
    }

    private String getLessGstInternationalExpertsMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Author", properties.get("sTaxArticle:author"));
            response.put("Publication Date", properties.get("sTaxArticle:publicationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
            {
              "error": "Failed to fetch GST International Experts summary"
            }
            """;
        }
    }



    private String getLessGstDeloitteExpertsMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Author", properties.get("sTaxArticle:author"));
            response.put("Publication Date", properties.get("sTaxArticle:publicationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
            {
              "error": "Failed to fetch GST Deloitte Experts summary"
            }
            """;
        }
    }

    private String getLesscommentaryMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("description", properties.get("cm:description"));
            response.put("Commentary Section", properties.get("sTaxComm:sTaxCommSection"));
            response.put("Commentary Chapter", properties.get("sTaxComm:chapter"));
            response.put("docSummery", properties.get("sTaxComm:docSummery"));
            response.put("pnID", properties.get("sTaxComm:pnID"));
            response.put("topicPnID", properties.get("sTaxComm:topicPnID"));
            response.put("topicName", properties.get("sTaxComm:topicName"));
            response.put("topicContent", properties.get("sTaxComm:topicContent"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch GST Experts Analysis summary"
                }
                """;
        }
    }

    private String getLessArticleMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxNotification:subject"));
            response.put("StaxNotificationDate", properties.get("sTaxNotification:sTaxNotificationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Articles summary"
                }
                """;
        }
    }

    private String getLessGstQAMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("Subject", properties.get("sTaxQuestionAnswer:subject"));
            response.put("description", properties.get("cm:description"));
            response.put("pnID", properties.get("sTaxQuestionAnswer:pnID"));
            response.put("questionNo", properties.get("sTaxQuestionAnswer:questionNo"));
            response.put("ChapterName", properties.get("sTaxQuestionAnswer:ChapterName"));

            response.put("sTaxQuestionAnswerDate", properties.get("sTaxQuestionAnswer:sTaxNotificationDate"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch GST QA summary"
                }
                """;
        }
    }

    private String getLessVatReadyReckonerMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("description", properties.get("cm:description"));
            response.put("Subject", properties.get("sTaxVATEAnalysis:subject"));
            response.put("sTaxVATEAnalysisDate", properties.get("sTaxVATEAnalysis:sTaxVATEAnalysisDate"));
            response.put("pnID", properties.get("sTaxVATEAnalysis:pnID"));
            response.put("author", properties.get("sTaxVATEAnalysis:author"));
            response.put("topicPnID", properties.get("sTaxVATEAnalysis:topicPnID"));
            response.put("topicName", properties.get("sTaxVATEAnalysis:topicName"));
            response.put("topicNameHTML", properties.get("sTaxVATEAnalysis:topicNameHTML"));
            response.put("topicContent", properties.get("sTaxVATEAnalysis:topicContent"));



            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch VAT Ready Reckoner summary"
                }
                """;
        }
    }

    private String getLessGstRcmReckonerMetaData(Map<String, Object> fullMetadata, String nodeId) {
        try {
            Map<String, Object> properties =
                    (Map<String, Object>) fullMetadata.get("properties");

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("NodeId", nodeId);
            response.put("Title", properties.get("cm:title"));
            response.put("description", properties.get("cm:description"));
            response.put("Subject", properties.get("sTaxSTEAnalysis:subject"));
            response.put("sTaxSTEAnalysisDate", properties.get("sTaxSTEAnalysis:date"));
            response.put("pnID", properties.get("sTaxSTEAnalysis:pnID"));
            response.put("author", properties.get("sTaxSTEAnalysis:date"));
            response.put("commentaryType", properties.get("sTaxSTEAnalysis:commentaryType"));
            response.put("topicPnID", properties.get("sTaxSTEAnalysis:topicPnID"));
            response.put("topicNameHTML", properties.get("sTaxSTEAnalysis:topicNameHTML"));
            response.put("topicName", properties.get("sTaxSTEAnalysis:topicName"));
            response.put("topicContent", properties.get("sTaxSTEAnalysis:topicContent"));
            response.put("subTopicName", properties.get("sTaxSTEAnalysis:subTopicName"));
            response.put("subTopicContent", properties.get("sTaxSTEAnalysis:subTopicContent"));
            response.put("published", properties.get("sTaxSTEAnalysis:published"));
            response.put("subTopicNameHTML", properties.get("sTaxSTEAnalysis:subTopicNameHTML"));

            return objectMapper.writeValueAsString(response);

        } catch (Exception e) {
            log.error("exception", e);
            return """
                {
                  "error": "Failed to fetch Gst RCM summary"
                }
                """;
        }
    }

    private String fetchAlfrescoNodeMetadataXml(String nodeId) {
        String url = alfrescoBaseUrl
                + "/alfresco/service/api/node/workspace/SpacesStore/"
                + nodeId;

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(alfrescoUsername, alfrescoPassword);
        headers.setAccept(List.of(MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.ALL));

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class
        );

        return response.getBody();


    }

    private Map<String, Object> convertAlfrescoXmlToJson(String nodeId, String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(
                    new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))
            );

            document.getDocumentElement().normalize();

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("nodeId", nodeId);
            result.put("nodeRef", "workspace://SpacesStore/" + nodeId);

            // Atom basic fields
            result.put("id", getTextByLocalName(document, "id"));
            result.put("title", getTextByLocalName(document, "title"));
            result.put("summary", getTextByLocalName(document, "summary"));
            result.put("published", getTextByLocalName(document, "published"));
            result.put("updated", getTextByLocalName(document, "updated"));
            result.put("author", getAuthorName(document));

            // Content URL
            Element contentElement = getFirstElementByLocalName(document, "content");
            if (contentElement != null) {
                result.put("contentType", contentElement.getAttribute("type"));
                result.put("contentUrl", contentElement.getAttribute("src"));
            }

            // CMIS properties
            Map<String, Object> properties = extractCmisProperties(document);
            result.put("properties", properties);

            // Custom properties only
            Map<String, Object> customProperties = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                if (entry.getKey().contains(":")
                        && !entry.getKey().startsWith("cmis:")
                        && !entry.getKey().startsWith("cm:")
                        && !entry.getKey().startsWith("alfcmis:")
                        && !entry.getKey().startsWith("app:")
                        && !entry.getKey().startsWith("cch:")) {
                    customProperties.put(entry.getKey(), entry.getValue());
                }
            }
            result.put("customProperties", customProperties);

            // Alfresco aspects
            result.put("aspects", extractAspects(document));

            // Useful direct fields
            result.put("name", properties.get("cmis:name"));
            result.put("objectType", properties.get("cmis:objectTypeId"));
            result.put("baseType", properties.get("cmis:baseTypeId"));
            result.put("createdBy", properties.get("cmis:createdBy"));
            result.put("lastModifiedBy", properties.get("cmis:lastModifiedBy"));
            result.put("creationDate", properties.get("cmis:creationDate"));
            result.put("lastModificationDate", properties.get("cmis:lastModificationDate"));
            result.put("mimeType", properties.get("cmis:contentStreamMimeType"));
            result.put("", properties.get("cmis:contentStreamLength"));
            result.put("version", properties.get("cmis:versionLabel"));

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Alfresco XML metadata to JSON", e);
        }
    }

    private Map<String, Object> extractCmisProperties(Document document) {
        Map<String, Object> properties = new LinkedHashMap<>();

        NodeList allNodes = document.getElementsByTagNameNS("*", "*");

        for (int i = 0; i < allNodes.getLength(); i++) {
            Node node = allNodes.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Element element = (Element) node;
            String localName = element.getLocalName();

            if (localName != null && localName.startsWith("property")) {
                String propertyName = element.getAttribute("propertyDefinitionId");

                if (propertyName == null || propertyName.isBlank()) {
                    propertyName = element.getAttribute("queryName");
                }

                if (propertyName == null || propertyName.isBlank()) {
                    continue;
                }

                List<String> values = getChildValues(element);

                if (values.isEmpty()) {
                    properties.put(propertyName, null);
                } else if (values.size() == 1) {
                    properties.put(propertyName, convertValue(values.get(0), localName));
                } else {
                    properties.put(propertyName, values);
                }
            }
        }

        return properties;
    }

    private List<String> getChildValues(Element propertyElement) {
        List<String> values = new ArrayList<>();

        NodeList children = propertyElement.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            if (child.getNodeType() == Node.ELEMENT_NODE
                    && "value".equals(child.getLocalName())) {
                values.add(child.getTextContent());
            }
        }

        return values;
    }

    private Object convertValue(String value, String propertyType) {
        if (value == null) {
            return null;
        }

        if (propertyType == null) {
            return value;
        }

        try {
            if (propertyType.equals("propertyInteger")) {
                return Long.parseLong(value);
            }

            if (propertyType.equals("propertyBoolean")) {
                return Boolean.parseBoolean(value);
            }

            if (propertyType.equals("propertyDecimal")) {
                return Double.parseDouble(value);
            }

            // Keep date-time as string to avoid timezone conversion issues
            if (propertyType.equals("propertyDateTime")) {
                return value;
            }

            return value;

        } catch (Exception ex) {
            return value;
        }
    }

    private List<String> extractAspects(Document document) {
        List<String> aspects = new ArrayList<>();

        NodeList nodes = document.getElementsByTagNameNS("*", "appliedAspects");

        for (int i = 0; i < nodes.getLength(); i++) {
            String aspect = nodes.item(i).getTextContent();

            if (aspect != null && !aspect.isBlank()) {
                aspects.add(aspect);
            }
        }

        return aspects;
    }

    private String getTextByLocalName(Document document, String localName) {
        NodeList nodes = document.getElementsByTagNameNS("*", localName);

        if (nodes.getLength() == 0) {
            return null;
        }

        return nodes.item(0).getTextContent();
    }

    private Element getFirstElementByLocalName(Document document, String localName) {
        NodeList nodes = document.getElementsByTagNameNS("*", localName);

        if (nodes.getLength() == 0) {
            return null;
        }

        return (Element) nodes.item(0);
    }

    private String getAuthorName(Document document) {
        NodeList authors = document.getElementsByTagNameNS("*", "author");

        if (authors.getLength() == 0) {
            return null;
        }

        Element author = (Element) authors.item(0);
        NodeList names = author.getElementsByTagNameNS("*", "name");

        if (names.getLength() == 0) {
            return null;
        }

        return names.item(0).getTextContent();
    }




}