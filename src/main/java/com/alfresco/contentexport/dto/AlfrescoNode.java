package com.alfresco.contentexport.dto;

import java.util.Map;

public class AlfrescoNode {

    private String id;
    private String name;
    private String nodeType;
    private Boolean isFolder;
    private Boolean isFile;
    private String createdAt;
    private String modifiedAt;
    private AlfrescoContent content;
    private AlfrescoPath path;
    private Map<String, Object> properties;

    public boolean isFolder() {
        return Boolean.TRUE.equals(isFolder);
    }

    public boolean isFile() {
        return Boolean.TRUE.equals(isFile);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNodeType() {
        return nodeType;
    }

    public Boolean getIsFolder() {
        return isFolder;
    }

    public Boolean getIsFile() {
        return isFile;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public AlfrescoContent getContent() {
        return content;
    }

    public AlfrescoPath getPath() {
        return path;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public void setIsFolder(Boolean isFolder) {
        this.isFolder = isFolder;
    }

    public void setIsFile(Boolean isFile) {
        this.isFile = isFile;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setContent(AlfrescoContent content) {
        this.content = content;
    }

    public void setPath(AlfrescoPath path) {
        this.path = path;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}