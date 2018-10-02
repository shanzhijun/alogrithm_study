package com.alogrithm.tree;

/**
 * 二叉树的实现
 */
public class TreeImpl {
    private TreeNode root;//根节点

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 插入节点
     */
    public void insertNode(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            TreeNode currentNode = root;
            TreeNode parent;
            while (true) {
                parent = currentNode;
                if (currentNode.getKeyData() > node.getKeyData()) {
                    currentNode = currentNode.getLeftNode();
                    if (currentNode == null) {
                        parent.setLeftNode(node);
                        break;
                    }
                } else {
                    currentNode = currentNode.getRightNode();
                    if (currentNode == null) {
                        parent.setRightNode(node);
                        break;
                    }
                }
            }
        }

    }

    /**
     * 根据关键字查询节点
     */
    public TreeNode searchNode(int keyData) {
        TreeNode currentNode = root;

        while (true) {
            if (currentNode == null) {
                return null;
            }
            if (currentNode.getKeyData() > keyData) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }

            if (currentNode != null && currentNode.getKeyData() == keyData) {
                return currentNode;
            }
        }
    }


    /**
     * 更新节点
     */
    public void updateNode(int keyData, int otherData) {
        TreeNode treeNode = searchNode(keyData);
        if (treeNode != null) {
            treeNode.setOtherData(otherData);
        } else {
            System.out.println("不存在修改节点");
        }
    }

    /**
     * 先序遍历
     */
    public void preorderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            treeNode.display();

            preorderTraversal(treeNode.getLeftNode());


            preorderTraversal(treeNode.getRightNode());

        }
    }

    /**
     * 中序遍历
     */
    public void inorderTraversal(TreeNode treeNode) {
        if (treeNode != null) {

            preorderTraversal(treeNode.getLeftNode());


            treeNode.display();


            preorderTraversal(treeNode.getRightNode());

        }
    }

    /**
     * 后序遍历
     */
    public void postorderTraversal(TreeNode treeNode) {
        if (treeNode != null) {

            postorderTraversal(treeNode.getLeftNode());


            postorderTraversal(treeNode.getRightNode());


            treeNode.display();
        }
    }
}

