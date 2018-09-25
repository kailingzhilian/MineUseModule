package com.kai.ling.leetcode.sort.quicksort;

import com.kai.ling.leetcode.sort.quicksort.AbstractQuickSort;

/**
 * Created by kai.wang
 * on 2018/9/25 0025.
 */

public class QuickSortOneWay extends AbstractQuickSort{

    protected int partition(int[] arr, int l, int r) {
        // 为了提高效率，减少造成快速排序的递归树不均匀的概率，
        // 对于一个数组，每次随机选择的数为当前 partition 操作中最小最大元素的可能性为 1/n
        int randomNum = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, l, randomNum);


        //将小于v的数据放在索引为j的位置
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, j + 1, i);
                j++;
            }
        }

        swap(arr, l, j);
        return j;
    }

}
