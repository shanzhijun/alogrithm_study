package com.alogrithm.griphic.undirectWeightedGraph;

/**
 * 优先级队列列
 */
public class ProrityQueue {

    private final int SIZE=20;//20条边

    private  Edge[] queArray;
    private int nEdges;//当前边数

    public ProrityQueue(){
        queArray=new Edge[SIZE];
        nEdges=0;
    }

    /**
     * 插入队列
     * @param item
     */
    public void insert(Edge item){
        int i=0;
        for(i=0;i<nEdges;i++){
            if(item.distance>=queArray[i].distance){//找到存储的位置了
                break;
            }
        }

        for(int j=nEdges;j>i;j--){
            queArray[j]=queArray[j-1];
        }

        queArray[i]=item;
        nEdges++;
    }

    /**
     * 删除最小的一个边
     * @return
     */
    public Edge removeMinEdge(){
        return queArray[--nEdges];
    }

    /**
     * 删除指定位置的边
     * @param n
     */
    public void removeEdge(int n){
        for(int i=n;i<nEdges-1;i++){
            queArray[i]=queArray[i+1];
        }
        nEdges--;
    }

    public Edge peekMin(){
        return queArray[nEdges-1];
    }

    public int size(){
        return  nEdges;
    }

    public boolean isEmpty(){
        return nEdges==0;
    }

    public Edge peekN(int n){
        return queArray[n];
    }

    public int find(int findDex){
        for(int j=0;j<nEdges;j++){
            if(queArray[j].destVert==findDex){
                return j;
            }
        }

        return -1;
    }
}
