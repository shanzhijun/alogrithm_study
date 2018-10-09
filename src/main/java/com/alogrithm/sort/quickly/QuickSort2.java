package com.alogrithm.sort.quickly;


import com.alogrithm.sort.BaseSort;

/**
 * 快速排序O(nlgn)
 */
public class QuickSort2 extends BaseSort {
    private int[] theArray;
    private int nElems;

    public QuickSort2(int size) {
        theArray = new int[size];
    }

    /**
     * 加入数据
     *
     * @param value
     */
    public void insert(int value) {
        theArray[nElems++] = value;
    }

    public int size() {
        return nElems;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    /**
     * 数量少的元素 使用插入排序
     *
     * @param leftIndex
     * @param rightIndex
     */
    public void recQuickSort(int leftIndex, int rightIndex) {
        int size = rightIndex - leftIndex + 1;
        if (size <= 10) {
            //插入排序
            insertSort(leftIndex, rightIndex);
        } else {
            int mValue = getMValue(leftIndex, rightIndex);

            int position = divide(leftIndex, rightIndex, mValue);

            recQuickSort(leftIndex, position - 1);
            recQuickSort(position, rightIndex);
        }


    }

    private void insertSort(int leftIndex, int rightIndex) {
        for (int i = leftIndex; i < rightIndex; i++) {
            for (int j = i+1; j>leftIndex; j--) {
                if (theArray[j] < theArray[j-1]) {
                    int temp = theArray[j];
                    theArray[j] = theArray[j-1];
                    theArray[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }

    /**
     * 三项数据取中
     *
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public int getMValue(int leftIndex, int rightIndex) {
        int mIndex = (leftIndex + rightIndex) / 2;
        if (theArray[leftIndex] > theArray[mIndex]) {
            swap(leftIndex, mIndex);
        }

        if (theArray[leftIndex] > theArray[rightIndex]) {
            swap(leftIndex, rightIndex);
        }

        if (theArray[rightIndex] < theArray[mIndex]) {
            swap(mIndex, rightIndex);
        }

        swap(mIndex, rightIndex - 1);

        return theArray[rightIndex - 1];
    }

    /**
     * 手工排序
     *
     * @param leftIndex
     * @param rightIndex
     */
    private void manualSort(int leftIndex, int rightIndex) {
        int size = rightIndex - leftIndex + 1;//元素的排序数量
        if (size <= 1) {
            return;
        }
        if (size == 2) {
            if (theArray[leftIndex] > theArray[rightIndex]) {
                swap(leftIndex, rightIndex);

            }
        } else {
            if (theArray[leftIndex] > theArray[rightIndex - 1]) {
                swap(leftIndex, rightIndex - 1);
            }
            if (theArray[leftIndex] > theArray[rightIndex]) {
                swap(leftIndex, rightIndex);
            }
            if (theArray[rightIndex - 1] > theArray[rightIndex]) {
                swap(rightIndex - 1, rightIndex);
            }
        }
    }

    public int divide(int left, int right, int pivot) {
        int leftIndex = left;
        int rightIndex = right - 1;
        while (true) {
            while (leftIndex < rightIndex && theArray[++leftIndex] < pivot) ;
            while (rightIndex > 0 && theArray[--rightIndex] > pivot) ;
            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(leftIndex, rightIndex);
            }
        }

        swap(leftIndex, right - 1);

        return leftIndex;
    }

    public void swap(int left, int right) {
        int temp = theArray[left];
        theArray[left] = theArray[right];
        theArray[right] = temp;
    }
}
