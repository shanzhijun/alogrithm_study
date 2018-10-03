package com.alogrithm.heap;

public class Node {
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void display(){
        System.out.print(data+"  ");
    }
}
