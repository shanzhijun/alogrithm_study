package com.alogrithm.stack;

import org.junit.Test;

public class StackImpl {

    private int maxSize;//最大的存储数据量

    private Integer[] arr;//存储元素

    private int top;//指向最后加入栈的元素位置

    public StackImpl(){
        maxSize=10;
        arr=new Integer[maxSize];
        top=-1;
    }

    public StackImpl(int maxSize){
        this.maxSize=maxSize;
        arr=new Integer[maxSize];
        top=-1;
    }

    /**
     * 压入数据
     */

    public void push(int value){
        arr[++top]=value;
        if((top+1)==maxSize){
            //如果栈满了扩容
            expandStack();
        }
    }

    /**
     * 弹出数据
     * @return
     */
    public Integer pop(){
        return arr[top--];
    }

    public boolean isEmpty(){
        return top==-1;
    }
    /**
     * 扩容
     */
    public void expandStack(){
        maxSize=maxSize<<2;//扩充为2倍
        Integer[] newArr=new Integer[maxSize];
        for(int i=0;i<=top;i++){
            newArr[i]=arr[i];
        }
        arr=newArr;
    }
}
