package com.alogrithm.griphic.undirectedGraph;

import com.alogrithm.griphic.GraphicNode;

/**
 * 图的实现
 */
public class GraphicImpl {
    protected final int MAX_SIZE = 20;//最大顶点数
    protected GraphicNode[] graphicNodes;//顶点数组
    protected int adjMat[][];//邻接矩阵，用于标识顶点间是否连通
    protected int nVerts;//当前顶点数

    public GraphicImpl() {
        graphicNodes = new GraphicNode[MAX_SIZE];
        adjMat = new int[MAX_SIZE][MAX_SIZE];
        nVerts = 0;

        //初始化邻接矩阵，使得顶点间没有被链接（0：未连通，1：连通）
        for (int j = 0; j < MAX_SIZE; j++) {
            for (int k = 0; k < MAX_SIZE; k++) {
                adjMat[j][k] = 0;
            }
        }
    }

    /**
     * 添加顶点
     * @param label
     */
    public void addVertex(char label) {
        graphicNodes[nVerts++] = new GraphicNode(label);
    }

    /**
     * 添加边
     */
    public void addEdge(int start,int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }

    /**
     * 打印指定顶点
     * @param v
     */
    public void displayVertex(int v){
        System.out.println(graphicNodes[v].label);
    }


    /**
     * 获取当前顶点未访问的邻接节点位置
     * @param v
     * @return
     */
    public int getAdjUnVisitedVertex(int v){

        for(int i=0;i<MAX_SIZE;i++){
            //两个节点是连通，并且顶点是未访问
            if(adjMat[v][i]==1 && !graphicNodes[i].isVisted){
                return i;
            }
        }

        return -1;//未找到未访问的邻接节点的位置
    }
}