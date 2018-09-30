package com.alogrithm.queue;

/**
 * 循环队列
 */
public class CycleQueueImpl {

    private int[] arr;
    private int startIndex;//队头
    private int endIndex;//队尾
    private int maxSize;//最大空间
    private int elems;//有效数

    public CycleQueueImpl(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        elems=0;
        startIndex=0;
        endIndex=-1;
    }

    public void insert(int value){
        if(endIndex==(maxSize-1)){
            endIndex=-1;
        }
        arr[++endIndex]=value;
        elems++;
    }
    public int remove(){
        int temp=arr[startIndex++];
        if(startIndex==maxSize){
            startIndex=0;
        }
        elems--;
        return temp;
    }

    public boolean isEmpty(){
        return elems==0;
    }

    public boolean isFull(){
        return elems==maxSize;
    }
}
