package com.alfresco.contentexport.dto;

public class AlfrescoPath {

    private String name;
    private Boolean isComplete;

    public String getName() {
        return name;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }
}