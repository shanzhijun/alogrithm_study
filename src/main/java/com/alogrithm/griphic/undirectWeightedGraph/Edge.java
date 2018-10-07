package com.alogrithm.griphic.weightedGraph;

/**
 * 带权图的边
 */
public class Edge {
    public int srcVert;//源点
    public int destVert;//终点
    public int distance;//距离

    public Edge(int srcVert, int destVert, int distance) {
        this.srcVert = srcVert;
        this.destVert = destVert;
        this.distance = distance;
    }
}
