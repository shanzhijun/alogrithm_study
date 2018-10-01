package com.alogrithm.fibonacciSeries;

/**
 * Fibonacci数列问题：
 * 即数列中第1,2项为1，第n项由n-1项加n-2项得到
 */
public class FibonacciSeries {

    public static void main(String[] args){
        FibonacciSeries fibonacciSeries=new FibonacciSeries();
        System.out.println(fibonacciSeries.getValue(1));
        System.out.println(fibonacciSeries.getValue(2));
        System.out.println(fibonacciSeries.getValue(3));
        System.out.println(fibonacciSeries.getValue(4));
        System.out.println(fibonacciSeries.getValue(5));
        System.out.println(fibonacciSeries.getValue(6));
        System.out.println(fibonacciSeries.getValue(7));

    }

    /**
     * 递归实现
     */
    public int getValue(int n){
            if(n==1 || n==2){
                return 1;
            }else{
                return getValue(n-1)+getValue(n-2);
            }
    }
}
