package com.alogrithm.griphic.bfs_impl;

import com.alogrithm.griphic.GraphicImpl;

/**
 * 广度优先搜索实现
 */
public class BfsGraphicImpl extends GraphicImpl {
    private BfsQueue queue;

    public BfsGraphicImpl(){
        queue=new BfsQueue(MAX_SIZE);
    }

    public void bfs(){
        graphicNodes[0].isVisted=true;//第一个顶点标记为访问过的
        displayVertex(0);//显示访问的顶点
        queue.insert(0);

        int v2;
        while(!queue.isEmpty()){
            int v1=queue.remove();

            while((v2=getAdjUnVisitedVertex(v1))!=-1){
                graphicNodes[v2].isVisted=true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }

        for(int j=0;j<nVerts;j++){
            graphicNodes[j].isVisted=false;
        }
    }
}
