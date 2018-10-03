package com.alogrithm.hash.reHash;

import com.alogrithm.hash.DataItem;

/**
 * 再哈希法  实现哈希表
 */
public class ReHashImpl {
    private DataItem[] hashArray;
    private int arraySize;
    private  DataItem nonItem;
    public ReHashImpl(int arraySize) {
        this.arraySize = arraySize;
        hashArray=new DataItem[arraySize];
        nonItem=new DataItem(-1);
    }

    public void display(){
        for(int i=0;i<arraySize;i++){
            if(hashArray[i]!=null){
                System.out.print(hashArray[i].getKey()+" ");
            }else{
                System.out.print("**  ");
            }
        }
        System.out.println();
    }

    public int hashKey(int key){
        return key%arraySize;
    }

    public int reHashKey(int key){

        return 3-key%3;
    }

    public void insert(DataItem item){
       int key=item.getKey();
       int hashValue=hashKey(key);
       while(hashArray[hashValue]!=null && hashArray[hashValue].getKey()!=-1){
           hashValue+=reHashKey(key);
           hashValue%=arraySize;
       }
       hashArray[hashValue]=item;
    }

    public DataItem delete(int key){
        int hashValue=hashKey(key);
        int size=reHashKey(key);
        while(hashArray[hashValue].getKey()!=key){
            if(hashArray[hashValue].getKey()==key){
                DataItem item=hashArray[hashValue];
                hashArray[hashValue]=nonItem;
                return item;
            }
            hashValue+=size;
            hashValue%=arraySize;
        }
        return null;
    }
    public DataItem find(int key){
        int hashValue=hashKey(key);
        int size=reHashKey(key);
        while(hashArray[hashValue].getKey()!=key){
            if(hashArray[hashValue].getKey()==key){
                DataItem item=hashArray[hashValue];
                hashArray[hashValue]=nonItem;
                return item;
            }
            hashValue+=size;
            hashValue%=arraySize;
        }
        return null;
    }
}
