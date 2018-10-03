package com.alogrithm.tree.otherTree;

import java.util.jar.JarEntry;

/**
 * 2-3-4树
 */
public class Tree234Impl {
    private Tree234Node root=new Tree234Node();

    /**
     * 返回数据项
     * @param key
     * @return
     */
    public int find(int key){
        Tree234Node curentNode=root;
        int childNumber;
        while(true){
            if((childNumber=curentNode.findItem(key))>0){//找到了数据项
                return childNumber;
            }else if(curentNode.isLeaf()){//当前节点是叶子节点
                return -1;
            }else{
                curentNode=getNextChild(curentNode,key);
            }
        }
    }

    private Tree234Node getNextChild(Tree234Node curentNode, int value) {
        int j;
        int numItems=curentNode.getItemNum();//获取数据项的个数

        for(j=0;j<numItems;j++){
            if(value<curentNode.getItem(j).data){
                return curentNode.getChildNode(j);
            }
        }
        return curentNode.getChildNode(j);
    }

    /**
     * 新增数据项
     * @param value
     */
    public void insert(int value){
        Tree234Node curNode=root;
        Tree234Item tmpItem=new Tree234Item(value);
        while(true){
            if(curNode.isFull()){//如果当前系欸但那的数据项满了
                split(curNode);//拆分节点
                curNode=curNode.getParentNode();
                curNode=getNextChild(curNode,value);
            }else if(curNode.isLeaf()){//如果当前节点是叶子节点，而且没满
                break;//找到要插入数据的节点
            }else{
                curNode=getNextChild(curNode,value);
            }
        }
        curNode.insertItem(tmpItem);
    }


    /**
     * 拆分节点
     * @param thisNode
     */
    public void split(Tree234Node thisNode){
        Tree234Item itemB,itemC;
        Tree234Node parent,child2,child3;
        int itemIndex;

        itemC=thisNode.removeItem();//得到最大的数据项
        itemB=thisNode.removeItem();//得到中间的数据项

        child2=thisNode.disconnectChild(2);
        child3=thisNode.disconnectChild(3);

        Tree234Node newRight=new Tree234Node();

        if(thisNode==root){//如果是根
            root=new Tree234Node();
            parent=root;
            root.connectChild(0,thisNode);
        }else {
            parent = thisNode.getParentNode();
        }
        itemIndex = parent.insertItem(itemB);
        int num = parent.getItemNum();

        for (int i = num - 1; i > itemIndex; i--) {
            Tree234Node tmp = parent.disconnectChild(i);
            parent.connectChild(i + 1, tmp);
        }
        parent.connectChild(itemIndex + 1, newRight);
        newRight.insertItem(itemC);

        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public void displayTree(){
        recDisplayTree(root,0,0);
    }

    public void recDisplayTree(Tree234Node node,int level,int childNum){
        System.out.print("level="+level+" childNum="+childNum+" ");
        node.displayNode();

        int numItems=node.getItemNum();

        for(int i=0;i<numItems;i++){
            Tree234Node nextNode=node.getChildNode(i);

            if(nextNode!=null){
                recDisplayTree(nextNode,level+1,i);
            }else{
                return;
            }
        }
    }
}
