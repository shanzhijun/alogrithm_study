package com.alogrithm.tree.otherTree;

/**
 * 2-3-4树的节点
 */
public class Tree234Node {
    private static final int ORDER=4;//字节点的最大个数
    private int itemNum;//当前节点的数据项个数
    private Tree234Node parent;//记录父节点
    private Tree234Node[] childNodes=new Tree234Node[ORDER];//子节点
    private Tree234Item[] tree234Items=new Tree234Item[ORDER-1];//数据项

    /**
     * 获取指定的子节点
     * @param childNum
     * @return
     */
    public Tree234Node getChildNode(int childNum){
        return childNodes[childNum];
    }

    /**
     * 获取该节点的父节点
     * @return
     */
    public Tree234Node getParentNode(){
        return parent;
    }

    /**
     * 判断是否为叶子节点
     */
    public boolean isLeaf(){
        return childNodes[0]==null;
    }

    /**
     * 获取子节点的数据项个数
     */
    public int getItemNum(){
        return itemNum;
    }

    /**
     * 获取某个数据项
     * @return
     */
    public Tree234Item getItem(int index){
        return tree234Items[index];
    }

    /**
     * 判断节点的数据项是否已经满了
     */
    public boolean isFull(){
        return itemNum==(ORDER-1);
    }

    /**
     * 链接子节点
     */
    public void connectChild(int childNum,Tree234Node child){
        childNodes[childNum]=child;
        if(child!=null){
            child.parent=this;
        }
    }

    /**
     * 拆分子节点
     * @param childNum
     * @return
     */
    public Tree234Node disconnectChild(int childNum){
        Tree234Node tmp=childNodes[childNum];
        childNodes[childNum]=null;
        return tmp;
    }

    /**
     * 从当前节点中查找数据项
     * @return
     */
    public int findItem(int key){
        for(int i=0;i<(ORDER-1);i++){
            if(tree234Items[i]==null){
                break;
            }else if(tree234Items[i].data==key){
                return i;
            }
        }

        return -1;
    }

    /**
     * 插入数据项,调用该方法之前首先判断数据项是否已经满了，满了是不能调用改方法的
     * @return
     */
    public int insertItem(Tree234Item newItem){
        itemNum++;
        int newKey=newItem.data;
        for(int j=(ORDER-2);j>=0;j--){
            if(tree234Items[j]==null){
                continue;
            }else {
                int itsKey=tree234Items[j].data;
                if(newKey<itsKey){
                    tree234Items[j+1]=tree234Items[j];
                }else{
                    tree234Items[j+1]=newItem;
                    return j+1;
                }
            }
        }
        tree234Items[0]=newItem;
        return 0;
    }

    /**
     * 移除数据项
     * @return
     */
    public Tree234Item removeItem(){
        Tree234Item tmp=tree234Items[itemNum-1];
        tree234Items[itemNum-1]=null;
        itemNum--;
        return tmp;
    }

    /**
     * 展示该节点的数据项
     */
    public void displayNode(){
        for(int j=0;j<itemNum;j++){
            tree234Items[j].displayItem();
        }
        System.out.println();
    }
}
