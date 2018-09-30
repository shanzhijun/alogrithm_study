package com.alogrithm.sort;

import org.junit.Test;

/**
 * 选择排序
 */
public class SelectionSort extends BaseSort {
    /**
     * 增序排序
     */
    @Test
    public void selectionSort(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

        for(int j=0;j<arr.length;j++){
            int i=j;
            int mindex=j;
            //查询剩余元素中最小值的下标
            for(;i<arr.length-1;i++){
                if(arr[mindex]>arr[i+1]){
                    mindex=i+1;
                }
            }
            //交换
            if(j!=mindex){
                arr[j]=arr[j]^arr[mindex];
                arr[mindex]=arr[j]^arr[mindex];
                arr[j]=arr[j]^arr[mindex];
            }
        }


        soutSortVlaue(arr);
    }


    @Test
    public void selectionSort2(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

        int minIndex=0;
        for(int i=0;i<arr.length-1;i++){
            minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(i!=minIndex){
                arr[i]=arr[i]^arr[minIndex];
                arr[minIndex]=arr[i]^arr[minIndex];
                arr[i]=arr[i]^arr[minIndex];
            }
        }

        soutSortVlaue(arr);
    }
    /**
     * 增序排序
     */
    @Test
    public void selectionSort1(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    arr[i]=arr[i]^arr[j];
                    arr[j]=arr[i]^arr[j];
                    arr[i]=arr[i]^arr[j];
                }
            }
        }

        soutSortVlaue(arr);
    }
}
