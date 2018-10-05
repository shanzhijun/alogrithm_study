package com.alogrithm.griphic.bfs_impl;

import com.alogrithm.griphic.dfs_impl.DfsGraphicImpl;

public class BfsGraphicImplTest {
    public static void  main(String[] args){
        BfsGraphicImpl graphic=new BfsGraphicImpl();
        graphic.addVertex('A');
        graphic.addVertex('B');
        graphic.addVertex('C');
        graphic.addVertex('D');
        graphic.addVertex('E');

        graphic.addEdge(0,1);//A-B
        graphic.addEdge(0,2);//A-C
        graphic.addEdge(0,3);//A-D
        graphic.addEdge(1,3);//B-D
        graphic.addEdge(3,4);//D-E

        System.out.println("------------广度优先搜索-------------");
        graphic.bfs();
    }
}
