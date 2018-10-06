package com.alogrithm.griphic.directedGraph;

public class DirectedGraphImplTest {

    public static void  main(String[] args){
        DirectedGraphImpl graphic=new DirectedGraphImpl();
        graphic.addVerts('A');//0
        graphic.addVerts('B');//1
        graphic.addVerts('C');//2
        graphic.addVerts('D');//3
        graphic.addVerts('E');//4
        graphic.addVerts('F');//5
        graphic.addVerts('G');//6
        graphic.addVerts('H');//7


        graphic.addEdge(0,3);//AD
        graphic.addEdge(0,4);//AE
        graphic.addEdge(1,4);//BE

        graphic.addEdge(2,5);//CF

        graphic.addEdge(3,6);//DG

        graphic.addEdge(4,6);//EG

        graphic.addEdge(5,7);//FH

        graphic.addEdge(6,7);//GH

        System.out.println("------------最小生成树-------------");
        graphic.sorted();
    }
}
