package com.alogrithm.reverseWord;

import com.alogrithm.stack.StackImpl;
import org.junit.Test;

/**
 * 单词逆序
 * 1、方法一：将字符串变为char数组，倒序输出
 * 2、方法二：利用栈的先进后出的特性
 * 3、方法三：利用数学置换的思想：第一个和最后一个置换，第二个和倒数第二个置换，以此类推
 */
public class ReverseWord {

    /**
     * 将字符串变为char数组，倒序输出
     */
    @Test
    public void method1(){
        String str="hello";
        char[] chars = str.toCharArray();
        char[] newChars=new char[chars.length];
        for(int i=chars.length-1;i>=0;i--){
            newChars[chars.length-i-1]=chars[i];
        }
        String newStr=new String(newChars);
        System.out.println(newStr);
    }

    /**
     * 利用栈的先进后出的特性
     */
    @Test
    public void method2(){
        String str="hello";
        char[] chars = str.toCharArray();
        CharStack stack=new CharStack(chars.length);
        for(int i=0;i<chars.length;i++){
            stack.push(chars[i]);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    /**
     * 利用数学置换的思想
     */
    @Test
    public void method3(){
        String str="hello1";
        char[] chars = str.toCharArray();

        int leftIndex=0;
        int rightIndex=chars.length-1;
        while(leftIndex<rightIndex){
            char temp=chars[leftIndex];
            chars[leftIndex]=chars[rightIndex];
            chars[rightIndex]=temp;
            leftIndex++;
            rightIndex--;
        }
        System.out.println(new String(chars));
    }
}
