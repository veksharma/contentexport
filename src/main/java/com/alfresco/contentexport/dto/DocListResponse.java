package com.alfresco.contentexport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class DocListResponse {

    private int totalRecords;
    private int startIndex;
    private Metadata metadata;
    private List<DocListItem> items;

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<DocListItem> getItems() {
        return items;
    }

    public void setItems(List<DocListItem> items) {
        this.items = items;
    }

    public static class Metadata {

        private String repositoryId;
        private String container;
        private ParentNode parent;
        private boolean onlineEditing;
        private ItemCounts itemCounts;

        public String getRepositoryId() {
            return repositoryId;
        }

        public void setRepositoryId(String repositoryId) {
            this.repositoryId = repositoryId;
        }

        public String getContainer() {
            return container;
        }

        public void setContainer(String container) {
            this.container = container;
        }

        public ParentNode getParent() {
            return parent;
        }

        public void setParent(ParentNode parent) {
            this.parent = parent;
        }

        public boolean isOnlineEditing() {
            return onlineEditing;
        }

        public void setOnlineEditing(boolean onlineEditing) {
            this.onlineEditing = onlineEditing;
        }

        public ItemCounts getItemCounts() {
            return itemCounts;
        }

        public void setItemCounts(ItemCounts itemCounts) {
            this.itemCounts = itemCounts;
        }
    }

    public static class ItemCounts {

        private int folders;
        private int documents;

        public int getFolders() {
            return folders;
        }

        public void setFolders(int folders) {
            this.folders = folders;
        }

        public int getDocuments() {
            return documents;
        }

        public void setDocuments(int documents) {
            this.documents = documents;
        }
    }

    public static class ParentNode {

        private String nodeRef;
        private Permissions permissions;

        public String getNodeRef() {
            return nodeRef;
        }

        public void setNodeRef(String nodeRef) {
            this.nodeRef = nodeRef;
        }

        public Permissions getPermissions() {
            return permissions;
        }

        public void setPermissions(Permissions permissions) {
            this.permissions = permissions;
        }
    }

    public static class NodeRefParent {

        private String nodeRef;

        public String getNodeRef() {
            return nodeRef;
        }

        public void setNodeRef(String nodeRef) {
            this.nodeRef = nodeRef;
        }
    }

    public static class Permissions {

        private Boolean inherited;
        private List<String> roles;
        private UserAccess userAccess;

        public Boolean getInherited() {
            return inherited;
        }

        public void setInherited(Boolean inherited) {
            this.inherited = inherited;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public UserAccess getUserAccess() {
            return userAccess;
        }

        public void setUserAccess(UserAccess userAccess) {
            this.userAccess = userAccess;
        }
    }

    public static class UserAccess {

        @JsonProperty("cancel-checkout")
        private Boolean cancelCheckout;

        @JsonProperty("inline-edit")
        private Boolean inlineEdit;

        private Boolean permissions;
        private Boolean edit;
        private Boolean delete;
        private Boolean create;

        public Boolean getCancelCheckout() {
            return cancelCheckout;
        }

        public void setCancelCheckout(Boolean cancelCheckout) {
            this.cancelCheckout = cancelCheckout;
        }

        public Boolean getInlineEdit() {
            return inlineEdit;
        }

        public void setInlineEdit(Boolean inlineEdit) {
            this.inlineEdit = inlineEdit;
        }

        public Boolean getPermissions() {
            return permissions;
        }

        public void setPermissions(Boolean permissions) {
            this.permissions = permissions;
        }

        public Boolean getEdit() {
            return edit;
        }

        public void setEdit(Boolean edit) {
            this.edit = edit;
        }

        public Boolean getDelete() {
            return delete;
        }

        public void setDelete(Boolean delete) {
            this.delete = delete;
        }

        public Boolean getCreate() {
            return create;
        }

        public void setCreate(Boolean create) {
            this.create = create;
        }
    }

    public static class DocListItem {

        private String nodeRef;
        private String nodeType;
        private String type;
        private String mimetype;

        @JsonProperty("isFolder")
        private boolean folder;

        @JsonProperty("isLink")
        private boolean link;

        private String fileName;
        private String displayName;
        private String status;
        private String title;
        private String description;
        private String author;
        private String createdOn;
        private String createdBy;
        private String createdByUser;
        private String modifiedOn;
        private String modifiedBy;
        private String modifiedByUser;
        private String lockedBy;
        private String lockedByUser;
        private String size;
        private String version;
        private String contentUrl;
        private String webdavUrl;
        private String actionSet;
        private List<String> tags;
        private List<List<String>> categories;
        private String activeWorkflows;

        @JsonProperty("isFavourite")
        private boolean favourite;

        private Likes likes;
        private Location location;
        private Permissions permissions;
        private Map<String, Object> custom;
        private Map<String, Object> actionLabels;

        public String getNodeRef() {
            return nodeRef;
        }

        public void setNodeRef(String nodeRef) {
            this.nodeRef = nodeRef;
        }

        public String getNodeType() {
            return nodeType;
        }

        public void setNodeType(String nodeType) {
            this.nodeType = nodeType;
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

        public boolean isFolder() {
            return folder;
        }

        public void setFolder(boolean folder) {
            this.folder = folder;
        }

        public boolean isLink() {
            return link;
        }

        public void setLink(boolean link) {
            this.link = link;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getModifiedByUser() {
            return modifiedByUser;
        }

        public void setModifiedByUser(String modifiedByUser) {
            this.modifiedByUser = modifiedByUser;
        }

        public String getLockedBy() {
            return lockedBy;
        }

        public void setLockedBy(String lockedBy) {
            this.lockedBy = lockedBy;
        }

        public String getLockedByUser() {
            return lockedByUser;
        }

        public void setLockedByUser(String lockedByUser) {
            this.lockedByUser = lockedByUser;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
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

        public String getActionSet() {
            return actionSet;
        }

        public void setActionSet(String actionSet) {
            this.actionSet = actionSet;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<List<String>> getCategories() {
            return categories;
        }

        public void setCategories(List<List<String>> categories) {
            this.categories = categories;
        }

        public String getActiveWorkflows() {
            return activeWorkflows;
        }

        public void setActiveWorkflows(String activeWorkflows) {
            this.activeWorkflows = activeWorkflows;
        }

        public boolean isFavourite() {
            return favourite;
        }

        public void setFavourite(boolean favourite) {
            this.favourite = favourite;
        }

        public Likes getLikes() {
            return likes;
        }

        public void setLikes(Likes likes) {
            this.likes = likes;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Permissions getPermissions() {
            return permissions;
        }

        public void setPermissions(Permissions permissions) {
            this.permissions = permissions;
        }

        public Map<String, Object> getCustom() {
            return custom;
        }

        public void setCustom(Map<String, Object> custom) {
            this.custom = custom;
        }

        public Map<String, Object> getActionLabels() {
            return actionLabels;
        }

        public void setActionLabels(Map<String, Object> actionLabels) {
            this.actionLabels = actionLabels;
        }
    }

    public static class Likes {

        @JsonProperty("isLiked")
        private boolean liked;

        private int totalLikes;

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(int totalLikes) {
            this.totalLikes = totalLikes;
        }
    }

    public static class Location {

        private String repositoryId;
        private String site;
        private String siteTitle;
        private String container;
        private String path;
        private String file;
        private NodeRefParent parent;

        public String getRepositoryId() {
            return repositoryId;
        }

        public void setRepositoryId(String repositoryId) {
            this.repositoryId = repositoryId;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getSiteTitle() {
            return siteTitle;
        }

        public void setSiteTitle(String siteTitle) {
            this.siteTitle = siteTitle;
        }

        public String getContainer() {
            return container;
        }

        public void setContainer(String container) {
            this.container = container;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public NodeRefParent getParent() {
            return parent;
        }

        public void setParent(NodeRefParent parent) {
            this.parent = parent;
        }
    }
}
