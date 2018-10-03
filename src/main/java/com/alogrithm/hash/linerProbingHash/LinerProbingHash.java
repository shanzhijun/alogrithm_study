package com.alogrithm.hash.linerProbingHash;

import com.alogrithm.hash.DataItem;

/**
 * 线性探测hash表实现
 */
public class LinerProbingHash {
    private DataItem[] hashArray;
    private int arraySize;
    private  DataItem nonItem;

    public LinerProbingHash(int size){
        arraySize=size;
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

    /**
     * 得到hash化后的下标
     * @param key
     * @return
     */
    public int hashFunc(int key){
        return key%arraySize;
    }

    /**
     * 新增
     * @param item
     */
    public void insert(DataItem item){
        int key=item.getKey();
        int hashVal=hashFunc(key);

        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1){
            //位置被占用了
            hashVal++;
            hashVal=hashVal%arraySize;
        }

        hashArray[hashVal]=item;
    }

    /**
     * 删除
     * @param key
     * @return
     */
    public DataItem delete(int key){
        int hashVal=hashFunc(key);
        while(hashArray[hashVal]!=null){
            if(hashArray[hashVal].getKey()==key){
                DataItem tmp=new DataItem(-1);
                hashArray[hashVal]=nonItem;
                return tmp;
            }
            //位置被占用了
            hashVal++;
            hashVal=hashVal%arraySize;
        }

        return null;
    }

    /**
     * 查询
     * @param key
     */
    public DataItem find(int key){
        int hashVal=hashFunc(key);

        while(hashArray[hashVal]!=null){
            if(hashArray[hashVal].getKey()==key){
                return hashArray[hashVal];
            }
            //位置被占用了
            hashVal++;
            hashVal=hashVal%arraySize;
        }

        return null;
    }
}
