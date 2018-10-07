package com.alogrithm.griphic.directWeightedGraph;

/**
 * 路径
 */
public class DisPath {
    public int distance;
    public int parentVert;

    public DisPath( int parentVert,int distance) {
        this.distance = distance;
        this.parentVert = parentVert;
    }
}
