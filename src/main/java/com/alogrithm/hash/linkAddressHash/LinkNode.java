package com.alogrithm.hash.linkAddressHash;

public class LinkNode {
    private int data;
    public LinkNode next;

    public LinkNode(int data){
        this.data=data;
    }

    public int getKey(){
        return data;
    }

    public void display(){
        System.out.print(data+"  ");
    }

}
