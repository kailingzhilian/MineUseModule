package com.kai.ling.leetcode.sort;

import java.util.Arrays;

/**
 * Created by kai.wang
 * on 2018/8/21 0021.
 */
/**
 * Bubble Sort : * 该算法对一个数组中的相邻的每一对数字都进行比较，
 * 假如令大的在前，小的在后，该数组有n个元素
 * 第一次对该数组的所有相邻元素比较，
 * 比较完后则会排列出整个数组最小元素放在最后，
 * 接着第二次只需对剩下的 n-1 个相邻的元素进行比较，
 * 排序出第二小的元素， * 以此类推进行第 3，4，5，6，7...到 n-1 次
 * 因为第 n-1 次排出第二大的元素，自然剩下那个就是最大的元素 *
 * “这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。”
 * 每次排序‘浮’出的都是最小的 *
 * 算法复杂度分析
 * 时间复杂度（平均）   O(n^2) 外循环n次，内循环m次 m*n
 * 时间复杂度（最坏）   O(n^2) 外循环n次，内循环m次 m*n
 * 时间复杂度（最好）   O(n) (即已经数组按需排好的情况，加了flag判定后，内循环执行一次即可不再执行)
 * 空间复杂度           O(1)
 * 稳定性             稳定
 */

public class BubbleSort {

    public static void bubbleSort(int[] datas) {
        int count = 0;
        int temp;
        for (int i = 0; i < datas.length - 1; i++) {
            for (int j = i + 1; j < datas.length; j++) {
                count++;
                if (datas[i] > datas[j]) {
                    temp = datas[i];
                    datas[i] = datas[j];
                    datas[j] = temp;
                }
            }
        }
        System.out.println("Bubble Sort :");
        System.out.println(Arrays.toString(datas));
        System.out.println("count :" + count);
    }

}
