package com.alogrithm.hash.linkAddressHash;

import com.alogrithm.hash.DataItem;

import java.util.LinkedList;

/**
 * 哈希表，链地址法实现
 */
public class LinkAddressHashImpl {
    private SortedList[] hashArray;
    private int arraySize;
    public LinkAddressHashImpl(int arraySize){
        this.arraySize=arraySize;
        hashArray=new SortedList[arraySize];
        for(int i=0;i<arraySize;i++){
            hashArray[i]=new SortedList();
        }
    }
    public int hashKey(int key){
        return  key%arraySize;
    }

    public void insert(int key){
        int hashValue=hashKey(key);
        LinkNode node= new LinkNode(key);
        hashArray[hashValue].insert(node);
    }

    public void delete(int key){
        int hashValue=hashKey(key);
        hashArray[hashValue].delete(key);
    }

    public LinkNode find(int key){
        int hashValue=hashKey(key);
        return hashArray[hashValue].find(key);
    }

    public void display(){
        for(int i=0;i<arraySize;i++){
            hashArray[i].display(hashArray[i].getRoot());
        }
    }
}
