package com.kai.ling.leetcode.sort;

/**
 * Created by kai.wang
 * on 2018/9/4 0004.
 */

import java.util.Arrays;

/**
 * Straight Insertion Sort
 * 顾名思义，就是把一个新的元素插入已排好序的数组形成一个新的已排好序的数组
 * 从第一个元素开始，取下一个元素比较后实现排序，形成新的数组，
 * 再取第三个元素与该数组比较，
 * 比较时从该数组的最后一位开始比较，
 * 若新元素比与其比较的元素小，则将该比较的元素后移以为，
 * 直到新元素比该数组左边找到其应该插入的位置
 * 算法复杂度分析 * 时间复杂度（平均）   O(n^2) 外循环n次，内循环m次 m*n
 * 时间复杂度（最坏）   O(n^2) 外循环n次，内循环m次 m*n
 * 时间复杂度（最好）   O(n) ，数组已经排好序的情况，即当所有a[i] > a[i-1] 时不需要再执行内循环
 * 空间复杂度           O(1)
 * 稳定性             稳定
 * 平均比较和移动次数约为 (n^2)/4
 * 直接插入排序时简单排序中性能最好的
 * better than Selection & Bubble *
 */

public class InsertionSort {

    public static void insertionSort(int[] datas) {


        int temp;
        for (int i = 1; i < datas.length; i++) {
            temp = datas[i];
            for (int j = i - 1; j >= 0; j--) {
                if (datas[j] > temp) {
                    datas[j + 1] = datas[j];
                    datas[j]=temp;
                }
            }

        }
    }
}
