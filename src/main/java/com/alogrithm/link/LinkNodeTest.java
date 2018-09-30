package com.alogrithm.link;


import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public class LinkNodeTest {

    public static void main(String[] args){
        LinkNode node1=new LinkNode(10);
        LinkNode node2=new LinkNode(7);
        LinkNode node3=new LinkNode(9);

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(node1.getData());
        System.out.println(node1.getNext().getData());
        System.out.println(node1.getNext().getNext().getData());
    }
}
