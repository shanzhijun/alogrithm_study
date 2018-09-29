package com.alogrithm.sort;

import org.junit.Test;

/**
 * BubbleSort  冒泡排序
 */
public class BubbleSort extends BaseSort{

    /**
     * 一个没有顺序的整数数据，按照从大到小排序
     */
    @Test
    public void bubbleSort(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};
        for(int i=0;i<arr.length;i++){//遍历的次数
            for(int j=0;j<arr.length-1;j++){//比较是否调换数值
                if (arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        soutSortVlaue(arr);
    }

    /**
     * 由于每一次的遍历都会选出一个最大值，那么在第二次遍历的时候其比较的个数可以比第一次少一个，
     * 第三次遍历的时候其比较的的个数可以比第二次少一个，
     * 以此类推
     */
    @Test
    public void bubbleSort1(){
            int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j]>arr[j+1]){
                        int temp=arr[j+1];
                        arr[j+1]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        soutSortVlaue(arr);
    }

    /**
     * 利用位运算异或的特性，两次异或同一个数可以得到本身
     * 即 a^b^b=a
     */

    @Test
    public void bubbleSort2(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];//等价于arr[j]^arr[j+1]^arr[j+1]
                    arr[j]=arr[j]^arr[j+1];//等价于arr[j]^arr[j+1]^arr[j]^arr[j+1]^arr[j+1]
                }
            }
        }
        soutSortVlaue(arr);
    }
}
