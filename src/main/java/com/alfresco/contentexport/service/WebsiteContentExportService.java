package com.alfresco.contentexport.service;

import com.alfresco.contentexport.client.AlfrescoClient;
import com.alfresco.contentexport.config.AlfrescoProperties;
import com.alfresco.contentexport.dto.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WebsiteContentExportService {

    private final AlfrescoClient alfrescoClient;
    private final AlfrescoProperties properties;

    public WebsiteContentExportService(
            AlfrescoClient alfrescoClient,
            AlfrescoProperties properties
    ) {
        this.alfrescoClient = alfrescoClient;
        this.properties = properties;
    }

    public WebsiteContentExportResponse exportAllContent() {
        List<WebsiteContentItemDto> items = new ArrayList<>();

        exportFolderRecursively(properties.getRootFolderId(), items);

        return new WebsiteContentExportResponse(
                "alfresco-website",
                Instant.now().toString(),
                items.size(),
                items
        );
    }

    private void exportFolderRecursively(
            String folderId,
            List<WebsiteContentItemDto> items
    ) {
        AlfrescoChildrenResponse response = alfrescoClient.getChildren(folderId);

        for (AlfrescoNodeEntry child : response.getList().getEntries()) {
            AlfrescoNode node = child.getEntry();

            if (node.isFolder()) {
                exportFolderRecursively(node.getId(), items);
            } else {
                WebsiteContentItemDto dto = mapNodeToWebsiteContent(node);
                items.add(dto);
            }
        }
    }

    public WebsiteContentItemDto getContentById(String nodeId) {
        AlfrescoNode nodeEntry = alfrescoClient.getNode(nodeId);
        return mapNodeToWebsiteContent(nodeEntry);
    }

    public Resource downloadFile(String nodeId) {
        return alfrescoClient.downloadContent(nodeId);
    }

    private WebsiteContentItemDto mapNodeToWebsiteContent(AlfrescoNode node) {
        WebsiteContentItemDto dto = new WebsiteContentItemDto();

        dto.setId(node.getId());
        dto.setName(node.getName());
        dto.setMimeType(node.getContent() != null ? node.getContent().getMimeType() : null);
        dto.setAlfrescoPath(node.getPath() != null ? node.getPath().getName() : null);
        dto.setCreatedAt(node.getCreatedAt());
        dto.setModifiedAt(node.getModifiedAt());

        Map<String, Object> props = node.getProperties();

        if (props != null) {
            dto.setTitle((String) props.get("cm:title"));
            dto.setDescription((String) props.get("cm:description"));
        }

        if (isTextBased(dto.getMimeType())) {
            dto.setType("PAGE");
            dto.setContentText(alfrescoClient.downloadTextContent(node.getId()));
        } else {
            dto.setType("ASSET");
            dto.setDownloadUrl("/api/v1/website-content/files/" + node.getId());
        }

        return dto;
    }

    private boolean isTextBased(String mimeType) {
        return mimeType != null &&
                (
                        mimeType.equals("text/html") ||
                                mimeType.equals("text/plain") ||
                                mimeType.equals("application/json") ||
                                mimeType.equals("text/css") ||
                                mimeType.equals("application/javascript")
                );
    }
}