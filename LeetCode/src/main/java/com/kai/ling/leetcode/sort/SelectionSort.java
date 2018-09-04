package com.kai.ling.leetcode.sort;

/**
 * Created by kai.wang
 * on 2018/9/4 0004.
 */

/**
 * Selection Sort
 * 遍历数组，把最小（大）的元素放在数组首部，
 * 把剩下的元素看做一个数组，再次遍历，
 * 获得最小（大）的元素放在数组首部
 * 意在每次遍历新数组选择出最小（大）元素
 * 算法复杂度分析
 * 比较次数 n(n-1)/2 次
 * 时间复杂度（平均）   O(n^2) 外循环n次，内循环m次 m*n
 * 时间复杂度（最坏）   O(n^2) 外循环n次，内循环m次 m*n
 * 时间复杂度（最好）   O(n^2) 即不用元素交换，但仍要进行比较
 * 空间复杂度           O(1)
 * 稳定性             不稳定
 */

public class SelectionSort {

    public static void selectionSort(int[] datas) {
        int temp;
        for (int i = 0; i < datas.length - 1; i++) {
            for (int j = i + 1; j < datas.length; j++) {
                if (datas[i] > datas[j]) {
                    temp = datas[i];
                    datas[i] = datas[j];
                    datas[j] = temp;
                }
            }
        }
    }
}
