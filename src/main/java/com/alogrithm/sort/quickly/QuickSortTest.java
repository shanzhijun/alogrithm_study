package com.alogrithm.sort.quickly;

import com.alogrithm.sort.quickly.divideImpl.DivideImpl;

public class QuickSortTest {
    public static void main(String[] args){

        QuickSort sort=new QuickSort(16);
        for(int i=0;i<16;i++){
            int n= (int) (Math.random()*199);
            sort.insert(n);
        }

        System.out.println("生成的源数组：");
        sort.display();

        sort.quickSort();

        sort.display();


    }
}
