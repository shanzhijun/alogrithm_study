package com.alogrithm.griphic.undirectedGraph;

/**
 * 图节点
 */
public class GraphicNode {
    public char label;
    public boolean isVisted;//标记是否已经访问过，true 已经访问，false 未访问

    public GraphicNode(char label){
        this.label=label;
        isVisted=false;
    }
}
