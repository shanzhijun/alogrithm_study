package com.alogrithm.tree.otherTree;

/**
 * 2-3-4树的数据项
 */
public class Tree234Item {

    public int data;

    public Tree234Item(int data) {
        this.data = data;
    }

    public void displayItem(){
        System.out.print("/"+this.data);
    }
}
