package com.alogrithm.griphic.dfs_impl;

import com.alogrithm.griphic.GraphicImpl;

public class DfsGraphicImplTest {

    public static void  main(String[] args){
        DfsGraphicImpl graphic=new DfsGraphicImpl();
        graphic.addVertex('A');
        graphic.addVertex('B');
        graphic.addVertex('C');
        graphic.addVertex('D');
        graphic.addVertex('E');

        graphic.addEdge(0,1);//A-B
        graphic.addEdge(0,2);//A-C
        graphic.addEdge(0,3);//A-D
        graphic.addEdge(1,3);//B-D

        System.out.println("------------深度优先搜索-------------");
        graphic.dfs();
    }
}
