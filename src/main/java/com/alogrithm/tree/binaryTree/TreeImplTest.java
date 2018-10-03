package com.alogrithm.tree.binaryTree;

public class TreeImplTest {

    public static void main(String[] args){
        TreeImpl tree=new TreeImpl();
        TreeNode node1=new TreeNode(1,1);
        TreeNode node2=new TreeNode(2,2);
        TreeNode node3=new TreeNode(3,3);
        TreeNode node4=new TreeNode(4,4);
        TreeNode node5=new TreeNode(5,5);

        tree.insertNode(node3);

        tree.insertNode(node1);
        tree.insertNode(node2);

        tree.insertNode(node4);
        tree.insertNode(node5);


        tree.showTree();

        System.out.println("------------------查找结点-------------------");

        TreeNode treeNode = tree.searchNode(3);
        if(treeNode!=null){

            System.out.println("查找结点结果：");
            treeNode.display();

        }else{
            System.out.println("没有查找结点结果");
        }

        System.out.println("------------------修改结点-------------------");

        tree.updateNode(3,10);
        TreeNode treeNode2 = tree.searchNode(3);
        if(treeNode2!=null){

            System.out.println("修改节点后查找结点结果：");
            treeNode2.display();

        }else{
            System.out.println("修改节点后没有查找结点结果");
        }


        System.out.println("-------------------先序遍历-----------------------");
        tree.preorderTraversal(tree.getRoot());

        System.out.println("-------------------中序遍历-----------------------");
        tree.inorderTraversal(tree.getRoot());

        System.out.println("-------------------后序遍历-----------------------");
        tree.postorderTraversal(tree.getRoot());



    }
}
