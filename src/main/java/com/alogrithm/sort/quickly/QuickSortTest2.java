package com.alogrithm.sort.quickly;

public class QuickSortTest2 {
    public static void main(String[] args){

        QuickSort2 sort=new QuickSort2(16);
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
