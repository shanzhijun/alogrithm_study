package com.alogrithm.sort;

import org.junit.Test;

public class SearchInsertSort extends BaseSort{

    @Test
    public void searchInsertSort(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

        for(int i=1;i<arr.length;i++){

            int currentValue=arr[i];

            int leftIndex=0;
            int rightIndex=i-1;
            int middleIndex=0;

            //二分查找找到插入的位置
            while(leftIndex<=rightIndex){
                middleIndex=(leftIndex+rightIndex)/2;
                if(currentValue>arr[middleIndex]){
                    leftIndex=middleIndex+1;
                }else if(currentValue<arr[middleIndex]){
                    rightIndex=middleIndex-1;
                }else{
                    break;
                }
            }



            for(int j=rightIndex;j>middleIndex;j--){
                arr[rightIndex]=arr[j];
            }
            arr[middleIndex+1]=currentValue;
        }

        soutSortVlaue(arr);

    }
}
