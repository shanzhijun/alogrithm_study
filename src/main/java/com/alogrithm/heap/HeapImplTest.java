package com.alogrithm.heap;

import com.alogrithm.hash.linkAddressHash.LinkAddressHashImpl;
import com.alogrithm.hash.linkAddressHash.LinkNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapImplTest {
    public static void main(String[] args) throws IOException {
        int value;
        HeapImpl heapImpl=new HeapImpl(10);
        while(true){
            System.out.println("输入操作");

            char choice=getChar();

            switch (choice){
                case 's':
                    heapImpl.displayHeap();
                    break;
                case 'i':
                    System.out.println("输入插入的值");
                    value=getInt();
                    heapImpl.insert(value);
                    break;
                case 'r':
                    Node remove = heapImpl.remove();
                    System.out.println("删除成功"+remove.getData());
                    break;
                case 'c':
                    System.out.println("输入改变的key");
                    int index=getInt();
                    System.out.println("输入改变的值");
                    value=getInt();
                    heapImpl.change(index,value);
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
