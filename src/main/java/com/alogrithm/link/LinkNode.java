package com.alogrithm.link;

/**
 * 连接点
 */
public class LinkNode {

    private int data;//数据域

    private LinkNode next;//指针域

    public LinkNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
