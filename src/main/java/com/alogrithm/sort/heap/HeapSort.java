package com.alogrithm.sort.heap;

public class HeapSort {

    public  static void main(String[] args){
        int size=30;
        //随机生成数组
        Heap heap=new Heap(size);

        for(int i=0;i<size;i++){
            int random= (int) (Math.random()*100);
            heap.insertAt(i,random);
            heap.increSize();
        }

        System.out.println("生成的无序 数组为：");
        heap.displayHeap();
        System.out.println();

        //将无序的数据 转换为标准的堆的结构
        for(int i=size/2-1;i>=0;i--){

            heap.trickleDown(i);
        }

        System.out.println("生成标准堆的无序 数组为：");
        heap.displayHeap();
        System.out.println();

        //通过循环删除最大项从而排序
        for(int j=size-1;j>=0;j--){
            HeapNode remove = heap.remove();//返回的是最大数据项
            heap.insertAt(j,remove.getData());
        }

        System.out.println("生成的有序序 数组为：");
        heap.displayHeap();
        System.out.println();
    }
}
