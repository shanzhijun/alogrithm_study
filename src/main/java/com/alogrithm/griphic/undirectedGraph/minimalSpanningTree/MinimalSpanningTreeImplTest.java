package com.alogrithm.griphic.undirectedGraph.minimalSpanningTree;

public class MinimalSpanningTreeImplTest {
    public static void  main(String[] args){
        MinimalSpanningTreeImpl graphic=new MinimalSpanningTreeImpl();
        graphic.addVertex('A');
        graphic.addVertex('B');
        graphic.addVertex('C');
        graphic.addVertex('D');
        graphic.addVertex('E');

        graphic.addEdge(0,1);//A-B
        graphic.addEdge(0,2);//A-C
        graphic.addEdge(0,3);//A-D
        graphic.addEdge(0,4);//A-E

        graphic.addEdge(1,2);//B-C
        graphic.addEdge(1,3);//B-D
        graphic.addEdge(1,4);//B-E


        graphic.addEdge(2,3);//C-D
        graphic.addEdge(2,4);//C-E

        graphic.addEdge(3,4);//D-E



        System.out.println("------------最小生成树-------------");
        graphic.mst();
    }
}
