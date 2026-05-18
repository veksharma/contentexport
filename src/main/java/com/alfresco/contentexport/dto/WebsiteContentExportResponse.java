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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getExportedAt() {
        return exportedAt;
    }

    public void setExportedAt(String exportedAt) {
        this.exportedAt = exportedAt;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<WebsiteContentItemDto> getContent() {
        return content;
    }

    public void setContent(List<WebsiteContentItemDto> content) {
        this.content = content;
    }
}