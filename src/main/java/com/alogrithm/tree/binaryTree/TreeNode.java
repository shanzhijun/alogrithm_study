package com.alogrithm.tree.binaryTree;

/**
 * 树的节点
 */
public class TreeNode {
    private int keyData;//关键字 用于查找记录节点
    private int otherData;//其他数据
    private TreeNode leftNode;//左节点
    private TreeNode rightNode;//右节点

    public TreeNode(int keyData, int otherData) {
        this.keyData = keyData;
        this.otherData = otherData;
    }

    public int getKeyData() {
        return keyData;
    }

    public void setKeyData(int keyData) {
        this.keyData = keyData;
    }

    public int getOtherData() {
        return otherData;
    }

    public void setOtherData(int otherData) {
        this.otherData = otherData;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * 输出节点的值
     */

    public void display(){
        System.out.println("keyData="+keyData+",otherData="+otherData);
    }
}
