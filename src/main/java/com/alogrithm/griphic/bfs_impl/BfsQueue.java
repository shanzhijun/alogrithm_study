package com.alogrithm.griphic.bfs_impl;

/**
 * 广度优先搜索的队列
 */
public class BfsQueue {

    private int maxSize;
    private int[] queArray;
    private int start;
    private int end;

    public BfsQueue(int maxSize){
        this.maxSize=maxSize;
        queArray=new int[maxSize];
        start=0;
        end=-1;
    }

    public void insert(int value){
        if(end==maxSize-1){
            end=-1;
        }else{
            queArray[++end]=value;
        }
    }

    public int remove(){
        int tmp=queArray[start++];
        if(start==maxSize){
            start=0;
        }
        return tmp;
    }

    public boolean isEmpty(){
        return end+1==start || start+maxSize-1==end;
    }
}
