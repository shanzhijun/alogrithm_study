package com.alogrithm.heap;

public class HeapImpl {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public HeapImpl(int maxSize) {
        this.maxSize = maxSize;
        currentSize=0;
        heapArray=new Node[maxSize];
    }

    public boolean isEmpty(){
        return  currentSize==0;
    }

    public boolean insert(int key){
        if(currentSize==maxSize){
            //堆存储满了
            return false;
        }

        //将新节点放在数组的最后
        Node newNode=new Node(key);
        heapArray[currentSize]=newNode;

        trickleUp(currentSize);//把新节点进行比较向上调整
        currentSize++;//数据项数量增加
        return true;
    }

    /**
     * 将插入项做出位置的调整，
     *
     * @param index  插入项的索引
     */
    public void trickleUp(int index){

        int parentIndex=(index-1)/2;
        Node bottom=heapArray[index];//新插入节点

        //通过循环获取插入的位置
        while(index>0 && heapArray[parentIndex].getData()<bottom.getData()){
            heapArray[index]=heapArray[parentIndex];
            index=parentIndex;
            parentIndex=(parentIndex-1)/2;
        }
        heapArray[index]=bottom;

    }

    /**
     * 删除根
     * @return
     */
    public Node remove(){
        //获取最后一个元素，放在根节点
        Node root=heapArray[0];
        heapArray[0]=heapArray[--currentSize];
        trickleDown(0);

        return root;
    }


    /**
     * 将删除项做出位置的调整，
     *
     * @param index 删除项的索引
     */
    public void trickleDown(int index){
        int lagerChildIndex;//大的子节点的位置
        Node top=heapArray[index];
        while(index<currentSize/2){//如果未找到最下层
            int leftChildIndex=2*index+1;
            int rightChildIndex=leftChildIndex+1;

            if(rightChildIndex<currentSize && heapArray[leftChildIndex].getData()<heapArray[rightChildIndex].getData()){
                lagerChildIndex=rightChildIndex;
            }else{
                lagerChildIndex=leftChildIndex;
            }

            if(top.getData()>heapArray[lagerChildIndex].getData()){
                break;
            }

            heapArray[index]=heapArray[lagerChildIndex];
            index=lagerChildIndex;
        }

        heapArray[index]=top;

    }

    /**
     * 改变指定数据项的值
     * @param index  指定数据项的索引
     * @param newValue 指定数据项的新值
     * @return
     */

    public boolean change(int index,int newValue){
        if(index<0 || index>=currentSize){
            //无效的数据项位置
            return false;
        }

        int oldValue=heapArray[index].getData();
        heapArray[index].setData(newValue);

        //根据新旧值的大小关系调整位置
        if(oldValue>newValue){
            trickleDown(index);
        }else{
            trickleUp(index);
        }

        return true;
    }

    public void displayHeap(){
        for(int i=0;i<currentSize;i++){
            if(heapArray[i]!=null){
                heapArray[i].display();
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
        while (currentSize>0){
            if(column==0){
                for(int i=0;i<nBlanks;i++){
                    System.out.print(" ");
                }
            }

            System.out.print(heapArray[j].getData());

            j++;

            if(j==currentSize){
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

