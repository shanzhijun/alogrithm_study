package com.alogrithm.dataChange;

import org.junit.Test;

/**
 * 数据交换的方式
 * 1、使用中间变量交换数据
 * 2、使用加法和减法交换数据
 * 3、使用位运算的异或的特性 a^b^b=a
 */
public class DataChange {

    @Test
    public void testChangeData(){
        int arg1=1;
        int arg2=2;
        System.out.println("原始数据arg1="+arg1+";arg2="+arg2);
        //使用中间变量交换数据
        useTempDataChange(arg1,arg2);

        dataChange(arg1,arg2);

        dataChange2(arg1,arg2);
    }

    /**
     * 使用中间变量交换数据
     * @param arg1
     * @param arg2
     */
    public void useTempDataChange(int arg1,int arg2){
        int temp=arg1;
        arg1=arg2;
        arg2=temp;

        System.out.println("使用中间变量交换数据arg1="+arg1+";arg2="+arg2);
    }

    /**
     * 使用加法和减法交换数据
     * @param arg1
     * @param arg2
     */
    public void dataChange(int arg1,int arg2){
        arg1=arg1+arg2;
        arg2=arg1-arg2;
        arg1=arg1-arg2;
        System.out.println("使用加法和减法交换数据arg1="+arg1+";arg2="+arg2);
    }

    /**
     * 使用位运算的异或的特性
     * @param arg1
     * @param arg2
     */
    public void dataChange2(int arg1,int arg2){
        arg1=arg1^arg2;
        arg2=arg1^arg2;
        arg1=arg1^arg2;
        System.out.println("使用位运算的异或的特性arg1="+arg1+";arg2="+arg2);
    }
}
