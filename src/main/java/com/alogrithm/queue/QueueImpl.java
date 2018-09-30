package com.alogrithm.queue;

import java.util.Queue;

public class QueueImpl {
    private int[] arr;
    private int startIndex;//队头
    private int endIndex;//队尾
    private int maxSize;//最大空间
    private int elems;//有效数

    public QueueImpl(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        elems=0;
        startIndex=0;
        endIndex=-1;
    }

    public void insert(int value){
        arr[++endIndex]=value;
        elems++;
    }
    public int remove(){
        elems--;
        return arr[startIndex++];
    }

    public boolean isEmpty(){
        return elems==0;
    }

    public boolean isFull(){
        return endIndex==(maxSize-1);
    }
}
