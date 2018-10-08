package com.alogrithm.sort.quickly.divideImpl;

import com.alogrithm.griphic.directWeightedGraph.DisPath;

/**
 * 划分实现
 */
public class DivideImplTest {
    public static void main(String[] args){

        DivideImpl divide=new DivideImpl(16);
        for(int i=0;i<16;i++){
            int n= (int) (Math.random()*199);
            divide.insert(n);
        }

        System.out.println("生成的源数组：");
        divide.display();

        int i = divide.divideImpl(0, 15, 99);
        System.out.println("划分后的数组：");
        divide.display();

        System.out.println("分隔点的位置为："+i);
    }
}
