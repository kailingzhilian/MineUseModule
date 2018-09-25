package com.kai.ling.leetcode.sort.quicksort;

/**
 * Created by kai.wang
 * on 2018/9/25 0025.
 */

public class QuickSortThreeWay extends AbstractQuickSort {

    @Override
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 为了提高效率，减少造成快速排序的递归树不均匀的概率，
        // 对于一个数组，每次随机选择的数为当前 partition 操作中最小最大元素的可能性 降低 1/n!

        int randomNum = (int) (Math.random() * (right - left + 1) + left);
        swap(arr, left, randomNum);

        int v = arr[left];
        // 三路快速排序即把数组划分为大于 小于 等于 三部分
        //arr[l+1...lt] <v  arr[lt+1..i) =v  arr[gt...r] > v 三部分
        // 定义初始值得时候依旧可以保证这初始的时候这三部分都为空
        int leftEnd = left;
        int rightStart = right;
        int i = left + 1;

        while (i <= rightStart) {
            if (arr[i] < v) {
                swap(arr, i, leftEnd + 1);
                i++;
                leftEnd++;
            } else if (arr[i] == v) {
                i++;
            } else {
                swap(arr, i, rightStart);
                rightStart--;
                //i++ 注意这里 i 不需要加1 因为这次交换后 i 的值仍不等于 v 可能小于 v 也可能等于 v 所以交换完成后 i 的角标不变
            }
        }

        swap(arr, left, leftEnd);
        leftEnd--;
        quickSort(arr, left, leftEnd);
        quickSort(arr, rightStart, right);

    }


}
