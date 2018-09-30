package com.alogrithm.link;

public class LinkListImplTest {

    public static  void main(String[] args){
        LinkNode node1=new LinkNode(10);
        LinkNode node2=new LinkNode(7);
        LinkNode node3=new LinkNode(9);

        LinkListImpl linkList=new LinkListImpl();
        linkList.insert(node1);
        linkList.insert(node2);
        linkList.insert(node3);

        linkList.displayAll();
    }
}
