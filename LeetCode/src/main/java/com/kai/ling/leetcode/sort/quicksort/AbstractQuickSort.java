package com.kai.ling.leetcode.sort.quicksort;

/**
 * Created by kai.wang
 * on 2018/9/25 0025.
 */

public abstract class AbstractQuickSort implements QuickSort {


    @Override
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);

        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    protected int partition(int[] arr, int l, int r) {
        return 0;
    }


    //交换位置
    protected static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
