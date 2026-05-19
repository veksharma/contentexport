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

        private String nodeRef;
        private String type;
        private String mimetype;

        private String fileName;
        private String title;
        private String size;
        private String contentUrl;
        private String webdavUrl;

        public String getNodeRef() {
            return nodeRef;
        }

        public void setNodeRef(String nodeRef) {
            this.nodeRef = nodeRef;
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

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getContentUrl() {
            return contentUrl;
        }

        public void setContentUrl(String contentUrl) {
            this.contentUrl = contentUrl;
        }

        public String getWebdavUrl() {
            return webdavUrl;
        }

        public void setWebdavUrl(String webdavUrl) {
            this.webdavUrl = webdavUrl;
        }

    }
}
