package com.alfresco.contentexport.dto;

import java.util.List;

public class AlfrescoTreeResponseDto {

    private String rootNodeId;
    private Integer totalNodes;
    private List<AlfrescoTreeNodeDto> nodes;

    public String getRootNodeId() {
        return rootNodeId;
    }

    public void setRootNodeId(String rootNodeId) {
        this.rootNodeId = rootNodeId;
    }

    public Integer getTotalNodes() {
        return totalNodes;
    }

    public void setTotalNodes(Integer totalNodes) {
        this.totalNodes = totalNodes;
    }

    public List<AlfrescoTreeNodeDto> getNodes() {
        return nodes;
    }

    public void setNodes(List<AlfrescoTreeNodeDto> nodes) {
        this.nodes = nodes;
    }
}