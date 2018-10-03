package com.alogrithm.hash.linkAddressHash;

import com.alogrithm.hash.DataItem;
import com.alogrithm.hash.reHash.ReHashImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkAddressHashImplTest {

    public static void main(String[] args) throws IOException {
        int value;
        LinkAddressHashImpl linkAddressHashImpl=new LinkAddressHashImpl(10);
        while(true){
            System.out.println("输入操作");

            char choice=getChar();

            switch (choice){
                case 's':
                    linkAddressHashImpl.display();
                    break;
                case 'i':
                    System.out.println("输入插入的值");
                    value=getInt();
                    linkAddressHashImpl.insert(value);
                    break;
                case 'f':
                    System.out.println("输入查找的值");
                    value=getInt();
                    LinkNode linkNode = linkAddressHashImpl.find(value);
                    if(linkNode!=null){
                        System.out.println("找到了数据项value="+linkNode.getKey());
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
