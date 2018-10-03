package com.alogrithm.hash.linkAddressHash;

import org.junit.Test;

/**
 * 有序链表
 */
public class SortedList {
    private LinkNode root;

    public LinkNode getRoot() {
        return root;
    }

    /**
     * 按照降序链表插入
     * @param node
     */
    public void insert(LinkNode node){
        if(root==null){
            root=node;
        }else{
            LinkNode previous=null;
            LinkNode current=root;
            while(current!=null && current.getKey()>node.getKey()){
                previous=current;
                current=current.next;

            }
            if(previous==null){
                root=node;
            }else{
                previous.next=node;
            }

            node.next=current;
        }
    }


    public void delete(int key){
        LinkNode previous=null;
        LinkNode current=root;

        while(current!=null && current.getKey()!=key){
            previous=current;
            current=current.next;
        }
        if(previous==null){
            root=root.next;
        }else{
            previous.next=current.next;
        }
    }


    public LinkNode find(int key){
        LinkNode current=root;

        while(current!=null){
            if(current.getKey()==key){
                return current;
            }
            current=current.next;
        }

        return null;

    }


    public void display(LinkNode node){
        while(node!=null){
           node.display();
           node=node.next;
        }
    }

    @Test
    public void testSortedList(){
        SortedList sortedList=new SortedList();

        LinkNode node1=new LinkNode(10);

        sortedList.insert(node1);

        sortedList.display(sortedList.root);

        LinkNode node2=new LinkNode(9);

        sortedList.insert(node2);

        sortedList.display(sortedList.root);

        LinkNode node3=new LinkNode(11);

        sortedList.insert(node3);

        sortedList.display(sortedList.root);

    }

}
