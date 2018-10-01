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

        System.out.println("----------------输出节点---------------");
        linkList.displayAll();

        System.out.println("----------------查询节点---------------");
        LinkNode node = linkList.searchValue(19);
        if(node!=null){
            System.out.println("找到"+node.getData());
        }else{
            System.out.println("没有找到");
        }

        System.out.println("----------------删除节点---------------");
        linkList.removeValue(19);
        linkList.displayAll();
    }
}
