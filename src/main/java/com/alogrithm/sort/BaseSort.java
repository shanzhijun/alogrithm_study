package com.alogrithm.sort;

public class BaseSort {
    public void soutSortVlaue(int[] arr){
        if(arr==null|| arr.length==0){
            System.out.println("the input array is null or empty");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
}
