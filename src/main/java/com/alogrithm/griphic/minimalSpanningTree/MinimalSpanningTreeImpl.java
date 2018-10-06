package com.alogrithm.griphic.minimalSpanningTree;

import com.alogrithm.griphic.undirectedGraph.dfs_impl.DfsGraphicImpl;

/**
 * 最小生成树实现
 */
public class MinimalSpanningTreeImpl extends DfsGraphicImpl {

    /**
     * 最小生成树
     */
    public void mst(){
        graphicNodes[0].isVisted=true;//设置已经访问过了
        theStack.push(0);
        System.out.println("最小生成树，顶点链接结果为：");
        while(!theStack.isEmpty()){
            int currentNodeIndex=theStack.peek();
            int v=getAdjUnVisitedVertex(currentNodeIndex);//返回邻接节点的下标
            if(v==-1){
                theStack.pop();
            }else{
                graphicNodes[v].isVisted=true;
                theStack.push(v);//将该节点压入栈
                displayVertex(currentNodeIndex);
                displayVertex(v);
                System.out.print(" ");
            }
        }

        System.out.println();
        for (int i=0;i<nVerts;i++){
            graphicNodes[i].isVisted=false;
        }
    }

    /**
     * 重写打印方法
     * @param v
     */
    public void displayVertex(int v){
        System.out.print(graphicNodes[v].label);
    }
}
