package com.alogrithm.tree.otherTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree234ImplTest {

    public static  void main(String[] args) throws IOException{
        int value;
        Tree234Impl theTree=new Tree234Impl();
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

       while(true){
           System.out.println("输入操作");

           char choice=getChar();

           switch (choice){
               case 's':
                   theTree.displayTree();
                   break;
               case 'i':
                   System.out.println("输入插入的值");
                   value=getInt();
                   theTree.insert(value);
                   break;
               case 'f':
                   System.out.println("输入查找的值");
                   value=getInt();
                   int i = theTree.find(value);
                   if(i!=-1){
                       System.out.println("找到了数据项value="+value);
                   }else{
                       System.out.println("没有找到了数据项");
                   }
                   break;
                   default:
                       System.out.println("无效输入");

           }
       }

    }

    public  static String getString() throws IOException {
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(reader);
        return br.readLine();
    }

    public  static char getChar() throws IOException {

        return getString().charAt(0);
    }

    public  static int getInt() throws IOException {

        return Integer.parseInt(getString());
    }
}
