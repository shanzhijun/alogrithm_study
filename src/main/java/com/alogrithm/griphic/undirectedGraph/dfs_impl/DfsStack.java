package com.alogrithm.griphic.undirectedGraph.dfs_impl;

/**
 * 深度优先搜索使用的辅助栈
 */
public class DfsStack {
    private Integer[] array;//记录的数组
    private int maxSize;//栈的最大数据个数
    private int top;//栈的头指针，指向顶端节点

    /**
     * 初始化栈
     * @param maxSize
     */
    public DfsStack(int maxSize){
        this.maxSize=maxSize;
        array=new Integer[maxSize];
        top=-1;
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty(){
        return top==-1;
    }


    /**
     * 栈中加入数据
     */
    public void push(Integer value){
        array[++top]=value;
    }

    /**
     * 栈中弹出数据
     * @return
     */
    public Integer pop(){
        if(top>=0){
            return array[top--];
        }else{
             return null;
        }
    }


    /**
     *查看
     * @return
     */
    public int peek(){
        return array[top];
    }

}
