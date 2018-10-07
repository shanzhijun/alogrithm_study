package com.alogrithm.griphic.directWeightedGraph;

import com.alogrithm.griphic.undirectWeightedGraph.ProrityQueue;

import java.awt.*;

/**
 * 有向带权图
 */
public class DirectWeightedGraphImpl {
    private final int MAX_SIZE = 20;//图的最大顶点数
    private final int INFINITY = 10000;//标识不连通
    private Vertex[] vertexList;//顶点列表
    private int[][] adjMat;//邻接矩阵
    private int nVerts;//顶点个数
    private int nTree;
    private DisPath[] disPath;//路径

    private int currentVert;//当前顶点
    private int startToCurrent;

    public DirectWeightedGraphImpl() {
        vertexList = new Vertex[MAX_SIZE];
        adjMat = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                adjMat[i][j] = INFINITY;
            }
        }

        disPath = new DisPath[MAX_SIZE];
    }

    /**
     * 添加顶点
     *
     * @param lable
     */
    public void addVertex(char lable) {
        Vertex vertex = new Vertex(lable);
        vertexList[nVerts++] = vertex;
    }


    /**
     * 添加边
     *
     * @param start  起始顶点的索引
     * @param end    结束顶点的索引
     * @param weight 权重
     */
    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }

    /**
     * 最短路径计算
     */
    public void path() {
        int startIndex = 0;
        vertexList[startIndex].isVisited = true;
        nTree = 1;
        for (int i = 0; i < nVerts; i++) {
            int tmpDistance = adjMat[startIndex][i];
            disPath[i] = new DisPath(startIndex, tmpDistance);
        }
        while(nTree<nVerts){
            int indexMin=getMin();
            int minDist=disPath[indexMin].distance;
            if(minDist==INFINITY){
                System.out.println("没有连通");
                break;
            }else{
                currentVert=indexMin;
                startToCurrent=disPath[indexMin].distance;
            }

            vertexList[currentVert].isVisited=true;
            nTree++;

            adjust_sPath();//更新最短路径
        }

        displayPath();//显示路径

        nTree=0;
        for(int i=0;i<nVerts;i++){
            vertexList[i].isVisited=false;
        }
    }

    private void displayPath() {

        for(int i=0;i<nVerts;i++){
            System.out.print(vertexList[i].label+"=");
            if(disPath[i].distance==INFINITY){
                System.out.print("inf");
            }else{
                System.out.print(disPath[i].distance);
            }

            char parent=vertexList[disPath[i].parentVert].label;

            System.out.println("("+parent+")");

        }
        System.out.println();
    }

    private void adjust_sPath() {
        int column=1;
        while (column<nVerts){
            if(vertexList[column].isVisited){
                column++;
                continue;
            }

            int currentToDest=adjMat[currentVert][column];//当前顶点到目标顶点的距离
            int startToDest=startToCurrent+currentToDest;//起点到目标点的距离

            int dis=disPath[column].distance;

            if(startToDest<dis){
                disPath[column].parentVert=currentVert;
                disPath[column].distance=startToDest;
            }

            column++;
        }
    }

    public int getMin(){//从起点开始链接权值最小的相邻的顶点
        int minDist=INFINITY;
        int indexMin=0;

        for(int j=1;j<nVerts;j++){
            if(!vertexList[j].isVisited && disPath[j].distance<minDist){
                minDist=disPath[j].distance;
                indexMin=j;
            }
        }

        return indexMin;
    }
}
