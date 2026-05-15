package com.alfresco.contentexport.dto;

import java.util.List;

public class AlfrescoChildrenResponse {

    private AlfrescoList list;

    public AlfrescoList getList() {
        return list;
    }

    public void setList(AlfrescoList list) {
        this.list = list;
    }

    public static class AlfrescoList {
        private Pagination pagination;
        private List<AlfrescoNodeEntry> entries;

        public Pagination getPagination() {
            return pagination;
        }

        public void setPagination(Pagination pagination) {
            this.pagination = pagination;
        }

        public List<AlfrescoNodeEntry> getEntries() {
            return entries;
        }

        public void setEntries(List<AlfrescoNodeEntry> entries) {
            this.entries = entries;
        }
    }

    public static class Pagination {
        private Integer count;
        private Boolean hasMoreItems;
        private Integer totalItems;
        private Integer skipCount;
        private Integer maxItems;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Boolean getHasMoreItems() {
            return hasMoreItems;
        }

        public void setHasMoreItems(Boolean hasMoreItems) {
            this.hasMoreItems = hasMoreItems;
        }

        public Integer getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(Integer totalItems) {
            this.totalItems = totalItems;
        }

        public Integer getSkipCount() {
            return skipCount;
        }

        public void setSkipCount(Integer skipCount) {
            this.skipCount = skipCount;
        }

        public Integer getMaxItems() {
            return maxItems;
        }

        public void setMaxItems(Integer maxItems) {
            this.maxItems = maxItems;
        }
    }
}