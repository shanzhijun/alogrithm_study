package com.alogrithm.sort;

import org.junit.Test;

public class SearchInsertSort extends BaseSort{

    @Test
    public void searchInsertSort(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

        for(int i=0;i<arr.length-1;i++){

            int currentValue=arr[i+1];

            int leftIndex=0;
            int rightIndex=i;
            int middleIndex=0;

            //二分查找找到插入的位置
            while(leftIndex<=rightIndex){
                middleIndex=(leftIndex+rightIndex)/2;
                if(currentValue>arr[middleIndex]){
                    leftIndex=middleIndex+1;
                }else{

                    rightIndex=middleIndex-1;
                }
            }


            //移动位置，腾出位置
            for(int j=i;j>rightIndex;j--){
                arr[j+1]=arr[j];
            }
            //将需要插入的值放入到插入的位置
            arr[rightIndex+1]=currentValue;
        }

        soutSortVlaue(arr);

    }
}
