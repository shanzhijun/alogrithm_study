package com.alogrithm.sort.heap;

import com.alogrithm.heap.Node;

/**
 * 堆实现
 */
public class Heap {

    private HeapNode[] heapNodes;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        heapNodes=new HeapNode[maxSize];
    }

    /**
     * 判断当前堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return currentSize==0;
    }


    /**
     * 将数据依次放在数组中
     * @param index
     * @param value
     * @return
     */
    public boolean insertAt(int index,int value){
        HeapNode currentNode=new HeapNode(value);
        //将新节点放在数组的末尾
        heapNodes[index]=currentNode;

        return true;
    }

    public void increSize(){
        currentSize++;
    }

    public boolean insert(int value){
        if(currentSize==maxSize){
            //堆已经满了
            return false;
        }
        HeapNode currentNode=new HeapNode(value);
        //将新节点放在数组的末尾
        heapNodes[currentSize]=currentNode;

        trickleUp(currentSize);

        currentSize++;

        return true;
    }

    /**
     * 将插入项做出位置的调整，
     *
     * @param index  插入项的索引
     */
    public void trickleUp(int index){
        int parentIndex=(index-1)/2;
        HeapNode bottom=heapNodes[index];//新插入节点
        //通过循环获取插入的位置
        while(index>0 && heapNodes[parentIndex].getData()<bottom.getData()){
            heapNodes[index]=heapNodes[parentIndex];
            index=parentIndex;
            parentIndex=(parentIndex-1)/2;
        }
        heapNodes[index]=bottom;
    }

    public void trickleDown(int index){
        int maxIndex;//大的子节点的位置
        HeapNode top=heapNodes[index];
        while(index<currentSize/2){//如果未找到最下层
            int leftChildIndex=2*index+1;
            int rightChildIndex=leftChildIndex+1;

            if(rightChildIndex<currentSize && heapNodes[leftChildIndex].getData()<heapNodes[rightChildIndex].getData()){
                maxIndex=rightChildIndex;
            }else{
                maxIndex=leftChildIndex;
            }

            if(top.getData()>=heapNodes[maxIndex].getData()){
                break;
            }

            heapNodes[index]=heapNodes[maxIndex];
            index=maxIndex;
        }

        heapNodes[index]=top;

    }

    /**
     * 删除最大项
     * @return
     */
    public HeapNode remove(){
        //获取最后一个元素，放在根节点
        HeapNode root=heapNodes[0];
        heapNodes[0]=heapNodes[--currentSize];
        trickleDown(0);

        return root;
    }

    public void displayHeap(){
        for(int i=0;i<maxSize;i++){
            if(heapNodes[i]!=null){
                heapNodes[i].display();
            }else{
                System.out.print("--  ");
            }
        }
        System.out.println();


        System.out.println("----------------以树状图显示-----------------");

        int nBlanks=32;
        int itemsPreRow=1;
        int column=0;
        int j=0;
        while (maxSize>0){
            if(column==0){
                for(int i=0;i<nBlanks;i++){
                    System.out.print(" ");
                }
            }

            System.out.print(heapNodes[j].getData());

            j++;

            if(j==maxSize){
                break;
            }

            column++;
            if(column==itemsPreRow){//一层打印结束
                nBlanks/=2;
                itemsPreRow*=2;
                column=0;
                System.out.println();
            }else{
                for(int k=0;k<nBlanks*2-2;k++){
                    System.out.print(" ");
                }
            }
        }


    }
}
