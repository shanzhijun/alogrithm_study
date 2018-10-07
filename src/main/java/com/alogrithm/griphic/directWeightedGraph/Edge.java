package com.alogrithm.griphic.directWeightedGraph;

public class Edge {
    private int startVestex;//开始顶点
    private int endVestex;//结束顶点
    private int ININIT=Integer.MAX_VALUE-8;
    private int SIZE=20;
    private int weight;

    public Edge(int startVestex, int endVestex, int weight) {
        this.startVestex = startVestex;
        this.endVestex = endVestex;
        this.weight = weight;
    }
}
