package com.alfresco.contentexport.dto;

public class AlfrescoContent {

    private String mimeType;
    private String mimeTypeName;
    private Long sizeInBytes;
    private String encoding;

    public String getMimeType() {
        return mimeType;
    }

    public String getMimeTypeName() {
        return mimeTypeName;
    }

    public Long getSizeInBytes() {
        return sizeInBytes;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public void setMimeTypeName(String mimeTypeName) {
        this.mimeTypeName = mimeTypeName;
    }

    public void setSizeInBytes(Long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}