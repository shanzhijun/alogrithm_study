package com.alogrithm.sort.shell;

import com.alogrithm.sort.BaseSort;
import org.junit.Test;

/**
 * 希尔排序
 */
public class ShellSort extends BaseSort {

    @Test
    public void shellSort(){
        int[] arr={13,1,2,14,5,3,1,39,4,22,11,19};

        int length=arr.length;
        int h=0;
        while(h<length){
            h=3*h+1;
        }


        while(h>=1){
            System.out.println(h);
            for(int i=h;i<length;i++){

                int j = i - h;
                int get = arr[i];
                while (j >= 0 && arr[j] > get)
                {
                    arr[j + h] = arr[j];
                    j = j - h;
                }
                arr[j + h] = get;

            }
            soutSortVlaue(arr);
            System.out.println("");
            h=(h-1)/3;
        }

        soutSortVlaue(arr);
    }
}
