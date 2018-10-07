package com.alogrithm.griphic.directWeightedGraph;

import com.alogrithm.griphic.directWeightedGraph.DirectWeightedGraphImpl;

public class DirectWeightedGraphImplTest {

    public static void main(String[] args){
        DirectWeightedGraphImpl graph=new DirectWeightedGraphImpl();


        graph.addVertex('A');//0
        graph.addVertex('B');//1
        graph.addVertex('C');//2
        graph.addVertex('D');//3
        graph.addVertex('E');//4



        graph.addEdge(0,1,50);//AB 50
        graph.addEdge(0,3,80);//AD 80

        graph.addEdge(1,2,60);//BC 60
        graph.addEdge(1,3,90);//BD 90

        graph.addEdge(2,4,40);//CE 40

        graph.addEdge(3,4,70);//DE 70
        graph.addEdge(3,2,20);//DC 20

        graph.addEdge(4,1,50);//EB 50



        graph.path();
        System.out.println();


    }
}
