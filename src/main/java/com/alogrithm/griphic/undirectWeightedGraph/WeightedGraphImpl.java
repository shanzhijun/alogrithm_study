package com.alogrithm.griphic.undirectWeightedGraph;

import com.alogrithm.griphic.GraphicNode;

/**
 * 带权图实现
 */
public class WeightedGraphImpl {
    private int MAX_SIZE=20;//图的最大顶点数
    private GraphicNode[] vertexList;//顶点数组
    private int[][] adjMat;//邻接矩阵
    private int INFINITY=Integer.MAX_VALUE-8;//设置一个特别大的值作为权重,表示没有连接线
    private int nVerts;//当前图中的顶点数


    private int currentVert;
    private ProrityQueue thePQ;
    private int nTree;//表示最小生成树过程中，已访问过的顶点数量


    public WeightedGraphImpl(){
        vertexList=new GraphicNode[MAX_SIZE];
        adjMat=new int[MAX_SIZE][MAX_SIZE];
        for(int i=0;i<MAX_SIZE;i++){
            for(int j=0;j<MAX_SIZE;j++){
                adjMat[i][j]=INFINITY;
            }
        }
        thePQ=new ProrityQueue();
    }

    /**
     * 添加顶点
     * @param lable
     */
    public void addVertex(char lable){
        GraphicNode vertex=new GraphicNode(lable);
        vertexList[nVerts++]=vertex;
    }

    /**
     * 添加边
     * @param start 起始顶点的索引
     * @param end 结束顶点的索引
     * @param weight 权重
     */
    public void addEdge(int start,int end,int weight){
        adjMat[start][end]=weight;
        adjMat[end][start]=weight;
    }


    /**
     * 显示指定索引的顶点的值
     * @param index
     */
    public void display(int index){
        System.out.print(vertexList[index].label);
    }

    /**
     * 最小生成树
     */
    public void mstw(){
        currentVert=0;
        while(nTree<nVerts-1){
            vertexList[currentVert].isVisted=true;//顶点已经访问
            nTree++;
            for(int j=0;j<nVerts;j++){
                if(j==currentVert){
                    continue;//j和currentVert指向了同一个点就终止本次循环
                }
                if(vertexList[j].isVisted){
                    continue;//到这个点的边已经加入
                }
                int distance=adjMat[currentVert][j];//从邻接矩阵中取出权值
                if(distance==INFINITY){
                    continue;//两点之间没有链接
                }
                insertQueue(j,distance);//找到边并放入优先级队列中
            }

            if(thePQ.isEmpty()){
                System.out.println("图中无连接");
                return;
            }

            Edge theEage=thePQ.removeMinEdge();

            int srcVert=theEage.srcVert;//最小边的源点

            currentVert=theEage.destVert;//最小边的终点

            display(srcVert);
            display(theEage.destVert);
            System.out.print(" ");
        }

        for(int i=0;i<nVerts;i++){
            vertexList[i].isVisted=false;
        }
    }

    private void insertQueue(int newVert, int newDist) {
        int queueIndex=thePQ.find(newVert);
        if(queueIndex!=-1){
            Edge temp=thePQ.peekN(queueIndex);

            int oldDistance=temp.distance;
            if(oldDistance>newDist){
                thePQ.removeEdge(queueIndex);//删除旧的边
                Edge newEage=new Edge(currentVert,newVert,newDist);
                thePQ.insert(newEage);
            }
        }else{
            //队列中没有找到对应的边
            Edge newEage=new Edge(currentVert,newVert,newDist);
            thePQ.insert(newEage);
        }

    }
}
