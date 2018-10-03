package com.alogrithm.sort.insert;

import com.alogrithm.sort.BaseSort;
import org.junit.Test;

/**
 * 插入排序
 */
public class InsertSort extends BaseSort {

    @Test
    public void insertSort(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

        for (int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    arr[j-1]=arr[j-1]^arr[j];
                    arr[j]=arr[j-1]^arr[j];
                    arr[j-1]=arr[j-1]^arr[j];
                }else{
                    break;
                }
            }
        }

        soutSortVlaue(arr);
    }
}
