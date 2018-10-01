package com.alogrithm.link;

/**
 * 单向链表简单实现
 */
public class LinkListImpl {
    private LinkNode first;//头节点

    public void insert(LinkNode node) {
        if (first == null) {
            //首次插入节点
            first = node;
        } else {
            //非首次插入节点，切换指针域
            node.setNext(first);
            first = node;
        }
    }

    /**
     * 打印链表中的数据，
     * 链表中查询数据都只能从头节点开始
     */
    public void displayAll() {
        LinkNode currentNode = first;//当前节点指向头节点
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();//获取当前节点的下一个节点，当前节点的下一个节点为null时，链表遍历完成
        }
    }

    /**
     * 在链表中查询数据
     * @param value
     * @return
     */
    public LinkNode searchValue(int value){
        LinkNode currentNode = first;//当前节点指向头节点
        while(currentNode != null){
            if(currentNode.getData()==value){//判断当前节点的值是否与查询的值相同
                break;
            }
            currentNode = currentNode.getNext();//获取当前节点的下一个节点，当前节点的下一个节点为null时，链表遍历完成
        }

        return currentNode;
    }

    /**
     * 删除在链表中的数据
     * @param value
     * @return
     */
    public void removeValue(int value){
        LinkNode currentNode = first;//当前节点指向头节点
        LinkNode prevNode=first;//当前节点的上一个节点，初始时指向头节点
        while(currentNode != null){
            if(currentNode.getData()==value){//判断当前节点的值是否与查询的值相同
                break;
            }
            prevNode=currentNode;//上一个节点指向的是当前节点
            currentNode = currentNode.getNext();//获取当前节点的下一个节点，当前节点的下一个节点为null时，链表遍历完成
        }

        if(currentNode!=null){
            if(currentNode==first){//如果当前节点的应用来源于头节点，那么头节点直接指向当前节点的下一个节点
                first=currentNode.getNext();
            }else {
                prevNode.setNext(currentNode.getNext());//上一个节点的指针域指向当前节点的指针域
            }
        }
    }

}