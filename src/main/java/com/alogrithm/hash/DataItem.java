package com.alogrithm.hash;

/**
 * 数据项
 */
public class DataItem {
    private int iData;
    public DataItem(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return iData;
    }
}
