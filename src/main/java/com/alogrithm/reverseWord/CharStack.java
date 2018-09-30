package com.alogrithm.reverseWord;

public class CharStack {

    private char[] chars;
    private int top;
    private int maxSize;

    public CharStack(int maxSize){
        this.maxSize=maxSize;
        chars=new char[maxSize];
        top=-1;
    }


    public boolean isEmpty(){
        return top==-1;
    }

    public void push(char value){
        chars[++top]=value;
    }

    public char pop(){
        return chars[top--];
    }
}
