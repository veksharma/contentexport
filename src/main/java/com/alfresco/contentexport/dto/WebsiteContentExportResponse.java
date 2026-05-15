package com.alfresco.contentexport.dto;

import java.util.List;

public class WebsiteContentExportResponse {

    private String website;
    private String exportedAt;
    private int totalItems;
    private List<WebsiteContentItemDto> content;

    public WebsiteContentExportResponse(
            String website,
            String exportedAt,
            int totalItems,
            List<WebsiteContentItemDto> content
    ) {
        this.website = website;
        this.exportedAt = exportedAt;
        this.totalItems = totalItems;
        this.content = content;
    }

    // getters and setters
}