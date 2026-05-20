package com.alfresco.contentexport.dto;

import java.util.List;

public class DocListShortResponse {

    private int totalRecords;
    private List<DocListItem> items;

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<DocListItem> getItems() {
        return items;
    }

    public void setItems(List<DocListItem> items) {
        this.items = items;
    }

    public static class DocListItem {

        private static final String WORKSPACE_STORE_PREFIX = "workspace://SpacesStore/";

        private String nodeRef;
        private String type;
        private String mimetype;
        private String fileName;
        private String title;
        private String description;
        private String author;
        private String createdOn;
        private String createdBy;
        private String createdByUser;
        private String modifiedOn;
        private String modifiedBy;
        private String size;

        public String getNodeRef() {
            return nodeRef;
        }

        public void setNodeRef(String nodeRef) {
            if (nodeRef != null && nodeRef.startsWith(WORKSPACE_STORE_PREFIX)) {
                this.nodeRef = nodeRef.substring(WORKSPACE_STORE_PREFIX.length());
            } else {
                this.nodeRef = nodeRef;
            }
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMimetype() {
            return mimetype;
        }

        public void setMimetype(String mimetype) {
            this.mimetype = mimetype;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public String getCreatedOn() {
            return createdOn;
        }
        public void setCreatedOn(String createdOn) {
            this.createdOn = createdOn;
        }
        public String getCreatedBy() {
            return createdBy;
        }
        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }
        public String getCreatedByUser() {
            return createdByUser;
        }
        public void setCreatedByUser(String createdByUser) {
            this.createdByUser = createdByUser;
        }
        public String getModifiedOn() {
            return modifiedOn;
        }
        public void setModifiedOn(String modifiedOn) {
            this.modifiedOn = modifiedOn;
        }
        public String getModifiedBy() {
            return modifiedBy;
        }
        public void setModifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
        }
        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

    }
}
