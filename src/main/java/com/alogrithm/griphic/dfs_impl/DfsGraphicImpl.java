package com.alogrithm.griphic.dfs_impl;

import com.alogrithm.griphic.undirectedGraph.GraphicImpl;

/**
 * 深度优先搜索
 */
public class DfsGraphicImpl extends GraphicImpl {
    public DfsStack theStack;

    public DfsGraphicImpl(){
        theStack = new DfsStack(MAX_SIZE);
    }

    public void dfs(){//深度优先搜索
        graphicNodes[0].isVisted=true;//第一个顶点标记为访问过的
        displayVertex(0);//显示访问的顶点
        theStack.push(0);

        while (!theStack.isEmpty()){
            int v=getAdjUnVisitedVertex(theStack.peek());
            if(v==-1){
                theStack.pop();
            }else{
                graphicNodes[v].isVisted=true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for(int j=0;j<nVerts;j++){
            graphicNodes[j].isVisted=false;
        }
    }

}
