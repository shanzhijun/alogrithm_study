package com.alogrithm.sort.quickly.divideImpl;

/**
 * 划分实现
 */
public class DivideImpl {
    private int[] theArray;
    private int nElems;

    public DivideImpl(int size) {
        theArray=new int[size];
    }

    /**
     * 加入数据
     * @param value
     */
    public void insert(int value){
        theArray[nElems++]=value;
    }

    public int size(){
        return nElems;
    }

    public void display(){
        for(int i=0;i<nElems;i++){
            System.out.print(theArray[i]+" ");
        }
        System.out.println();
    }


    /**
     * 找到分界点的值的索引
     * @param left 左边的索引
     * @param right 右边的索引
     * @param pivot 分割点的值
     * @return
     */
    public int divideImpl(int left,int right,int pivot){
       int leftIndex=left-1;
       int rightIndex=right +1;

       while(true){
           //从左到右找到大于特定值的数据项
           while(left<right && theArray[++leftIndex]<pivot);//循环结束找到了位置
           //从右到左找到小于特定值的数据项
           while(left<right && theArray[--rightIndex]>pivot);

           if(leftIndex<rightIndex){
               theArray[leftIndex]=theArray[leftIndex]^ theArray[rightIndex];
               theArray[rightIndex]=theArray[leftIndex]^ theArray[rightIndex];
               theArray[leftIndex]=theArray[leftIndex]^ theArray[rightIndex];
           }else{
               break;
           }
       }

       return leftIndex;
    }
}
