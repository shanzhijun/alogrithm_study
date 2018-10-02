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
     * 删除节点
     * @param keyData
     */
    public void deleteNode(int keyData){
        TreeNode current=root;
        TreeNode parent=root;
        boolean isLeftChild=true;
       while(true){
           if(current==null){
               System.out.println("不存在要删除的节点");
               return;
           }

           parent=current;
           if(current.getKeyData()>keyData){
               current=current.getLeftNode();
               isLeftChild=true;
           }else{
               current=current.getRightNode();
               isLeftChild=false;
           }

           if(current != null &&current.getKeyData()==keyData){
               break;
           }
       }


       if(current.getLeftNode()==null && current.getRightNode()==null){  //删除的节点为叶子节点
           if(current==root){
               //要删除的是根节点
               root=null;
           }else if(isLeftChild){
               //删除的是节点的左节点
               parent.setLeftNode(null);
           }else {
               //删除的是节点的右节点
               parent.setRightNode(null);
           }

       }else if(current.getRightNode()==null){//要删除的节点只有一个左子节点
            if(current==root){
                //要删除的是根节点
                root=current.getLeftNode();
            }else if(isLeftChild){
                //删除的是节点的存在左节点
                parent.setLeftNode(current.getLeftNode());
            }else{
                //删除的是节点的存在右节点
                parent.setRightNode(current.getLeftNode());
            }
       }else if(current.getLeftNode()==null){//要删除的节点只有一个右子节点
           if(current==root){
               //要删除的是根节点
               root=current.getRightNode();
           }else if(isLeftChild){
               //删除的是节点的存在左节点
               parent.setLeftNode(current.getRightNode());
           }else{
               //删除的是节点的存在右节点
               parent.setRightNode(current.getRightNode());
           }
       }else{//要删除的节点有两个节点

           TreeNode successor=getSuccesor(current);
           if(successor==root){
               root=successor;
           }else if(isLeftChild){
               parent.setLeftNode(successor);
           }else{
               parent.setRightNode(successor);
           }
           successor.setLeftNode(current.getLeftNode());
       }

    }

    /**
     * 从删除节点中的右子节点中查询继承者
     * @param delNode
     * @return
     */
    private TreeNode getSuccesor(TreeNode delNode){
        TreeNode successorPerent=delNode;
        TreeNode successor=delNode;
        TreeNode current=delNode.getRightNode();

        while(current!=null){
            successorPerent=successor;
            successor=current;
            current=current.getLeftNode();
        }

        if(successor!=delNode.getRightNode()){
            successorPerent.setLeftNode(successor.getRightNode());
            successor.setRightNode(delNode.getRightNode());
        }

        return successor;

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

