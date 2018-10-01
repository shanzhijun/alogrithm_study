package com.alogrithm.triangleNum;

/**
 * 三角数字问题：
 * 即数列的第一项为1.第n项的值为第n-1项加n得到
 */
public class TriangleNum {

    public static void main(String[] args){
        TriangleNum triangleNum=new TriangleNum();

        System.out.println(triangleNum.getValue(1));
        System.out.println(triangleNum.getValue(2));
        System.out.println(triangleNum.getValue(3));
        System.out.println(triangleNum.getValue(4));

        System.out.println("------------递归实现------------");

        System.out.println(triangleNum.getValue2(1));
        System.out.println(triangleNum.getValue2(2));
        System.out.println(triangleNum.getValue2(3));
        System.out.println(triangleNum.getValue2(4));


    }

    /**
     * 非递归实现
     * @param n
     * @return
     */
    public int getValue(int n){
        int total=0;
        while(n>0){
            total+=n;
            n--;
        }
        return total;
    }


    /**
     * 递归实现
     */
    public int getValue2(int n) {
        if(n==1){
            return 1;
        }else{
            return n+getValue2(--n);
        }
    }
}
