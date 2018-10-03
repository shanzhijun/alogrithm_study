package com.alogrithm.sort.heap;

public class HeapNode {

    private int data;

    public HeapNode(int data) {
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void display(){
        System.out.print(data+"  ");
    }
}
