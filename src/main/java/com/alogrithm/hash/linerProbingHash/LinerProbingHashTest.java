package com.alogrithm.hash.linerProbingHash;

import com.alogrithm.tree.otherTree.Tree234Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinerProbingHashTest {
    public static void main(String[] args) throws IOException{
        int value;
        DataItem dataItem;
        LinerProbingHash linerProbingHash=new LinerProbingHash(10);
        while(true){
            System.out.println("输入操作");

            char choice=getChar();

            switch (choice){
                case 's':
                    linerProbingHash.display();
                    break;
                case 'i':
                    System.out.println("输入插入的值");
                    value=getInt();
                    dataItem=new DataItem(value);
                    linerProbingHash.insert(dataItem);
                    break;
                case 'f':
                    System.out.println("输入查找的值");
                    value=getInt();
                    dataItem = linerProbingHash.find(value);
                    if(dataItem!=null){
                        System.out.println("找到了数据项value="+dataItem.getKey());
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
