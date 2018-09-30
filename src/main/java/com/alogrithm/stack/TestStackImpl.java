package com.alogrithm.stack;

import org.junit.Test;

public class TestStackImpl {

    @Test
    public void testStack(){
        StackImpl stack=new StackImpl(1);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);


        while(!stack.isEmpty()){
            System.out.println("弹出栈内数据："+stack.pop());
        }

    }
}
