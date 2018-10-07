package com.alogrithm.griphic.weightedGraph;

public class WeightedGraphImplTest {

    public static void main(String[] args){
        WeightedGraphImpl graph=new WeightedGraphImpl();


        graph.addVertex('A');//0
        graph.addVertex('B');//1
        graph.addVertex('C');//2
        graph.addVertex('D');//3
        graph.addVertex('E');//4
        graph.addVertex('F');//5


        graph.addEdge(0,1,6);//AB 6
        graph.addEdge(0,3,4);//AD 4
        graph.addEdge(1,2,10);//BC 10
        graph.addEdge(1,3,7);//BD 7
        graph.addEdge(1,4,7);//BE 7
        graph.addEdge(2,3,8);//CD 8
        graph.addEdge(2,4,5);//CE 5
        graph.addEdge(2,5,6);//CF 6
        graph.addEdge(3,4,12);//DE 12
        graph.addEdge(4,5,12);//EF 7

        graph.mstw();
        System.out.println();


    }
}
