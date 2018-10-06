package com.alogrithm.griphic.directedGraph;

import com.alogrithm.griphic.GraphicNode;

import javax.swing.*;

/**
 * 有向图实现
 */
public class DirectedGraphImpl {
    private final int MAX_SIZE=20;
    private GraphicNode[] vertexList;//图的顶点数组
    private int[][] adjMat;//图的邻接矩阵
    private  int nVerts;//当前顶点的数量
    private char[] sortedArray;//拓扑排序后的结果

    public DirectedGraphImpl(){
        vertexList=new GraphicNode[MAX_SIZE];
        adjMat=new int[MAX_SIZE][MAX_SIZE];
        for(int i=0;i<MAX_SIZE;i++){
            for(int j=0;j<MAX_SIZE;j++){
                adjMat[i][j]=0;
            }
        }

        sortedArray=new char[MAX_SIZE];
    }

    /**
     * 添加顶点
     * @param lable
     */
    public void addVerts(char lable){
        GraphicNode node=new GraphicNode(lable);
        vertexList[nVerts++]=node;
    }

    /**
     * 链接边
     * @param start 开始节点下标
     * @param end 终点下标
     */
    public void addEdge(int start,int end){
        adjMat[start][end]=1;
    }

    public void displayNode(int v){
        System.out.print(vertexList[v].label);
    }

    /**
     * 拓扑排序
     */
    public void sorted(){
        int srcVertsNum=nVerts;
        while (nVerts>0){
            int currentVertex=getNoSuccessors();
            if(currentVertex==-1){
                System.out.println("找不到没有后继顶点的顶点了");
                return;
            }
            sortedArray[nVerts-1]=vertexList[currentVertex].label;
            //删除顶点
            deleteVerts(currentVertex);
        }

        for(int i=0;i<srcVertsNum;i++){
            System.out.print(sortedArray[i]+" ");
        }
    }

    /**
     * 删除顶点
     * @param currentVertex
     */
    private void deleteVerts(int currentVertex) {
        if(currentVertex!=(nVerts-1)){

            for(int i=currentVertex;i<nVerts-1;i++){
                vertexList[i]=vertexList[i+1];
            }

            /**
             * 移动邻接矩阵行
             */
            for(int row=currentVertex;row<nVerts-1;row++){
                moveRowUp(row,nVerts);
            }

            /**
             * 移动邻接矩阵列
             */
            for(int col=currentVertex;col<nVerts-1;col++){
                moveColLeft(col,nVerts);
            }
        }

        nVerts--;//数量递减

    }

    private void moveRowUp(int row,int length){

        for(int col=0;col<length;col++){
            adjMat[row][col]=adjMat[row+1][col];
        }
    }

    private void moveColLeft(int col,int length){

        for(int row=0;row<length;row++){
            adjMat[row][col]=adjMat[row][col+1];
        }
    }
    /**
     * 查找图中没有后继顶点点的顶点下标
     * @return
     */
    private int getNoSuccessors() {
        boolean isEdge;
        for(int row=0;row<nVerts;row++){
            isEdge=false;
            for(int col=0;col<nVerts;col++){
                if(adjMat[row][col]>0){
                    isEdge=true;
                    break;
                }
            }

            if(!isEdge){
                return row;
            }
        }
        return -1;
    }
}
