package com.alogrithm.link;

/**
 * 单向链表简单实现
 */
public class LinkListImpl {
    private LinkNode first;

    public void insert(LinkNode node) {
        if (first == null) {
            //首次插入节点
            first = node;
        } else {
            //非首次插入节点，切换指针域
            LinkNode firstNext = first;
            node.setNext(firstNext);
            first = node;
        }
    }

    public void displayAll() {
        LinkNode currentNode = first;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }
}