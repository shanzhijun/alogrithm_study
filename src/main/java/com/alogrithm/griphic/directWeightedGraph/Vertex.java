package com.alogrithm.griphic.directWeightedGraph;

public class Vertex {
    public char label;
    public boolean isVisited;

    public Vertex(char label) {
        this.label = label;
        isVisited=false;
    }
}
