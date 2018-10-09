package com.alogrithm.sort.quickly;


import com.alogrithm.sort.BaseSort;

import javax.swing.*;

/**
 * 快速排序O(nlgn)
 */
public class QuickSort extends BaseSort {
    private int[] theArray;
    private int nElems;

    public QuickSort(int size) {
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

    public void quickSort(){
        recQuickSort(0,nElems-1);
    }

    public void recQuickSort(int leftIndex,int rightIndex){

        if(rightIndex-leftIndex<=0){
            return;
        }else{
            int pivot=theArray[rightIndex];
            int position=divide(leftIndex,rightIndex,pivot);


            recQuickSort(leftIndex,position-1);
            recQuickSort(position,rightIndex);

        }
    }

    public int divide(int left,int right,int pivot){
        int leftIndex=left-1;
        int rightIndex=right;
        while(true){
            while(leftIndex<rightIndex && theArray[++leftIndex]<pivot);
            while(rightIndex>0 && theArray[--rightIndex]>pivot);
            if(leftIndex>=rightIndex){
               break;
            }else{
                swap(leftIndex,rightIndex);
            }
        }

        swap(leftIndex,right);

        return leftIndex;
    }

    public void swap(int left,int right){
        int temp= theArray[left];
        theArray[left]=theArray[right];
        theArray[right]=temp;
    }
}
