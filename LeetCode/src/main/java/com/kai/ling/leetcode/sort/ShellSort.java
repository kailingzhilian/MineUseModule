package com.kai.ling.leetcode.sort;

/**
 * Created by kai.wang
 * on 2018/9/5 0005.
 */

import java.util.Arrays;

/**
 *  ShellSort 分组排序 
 *  又名缩小增量排序 
 *  将待排主序列根据人为规定的一个增量值分割成若干个子序列 
 *  对这些子序列进行插入排序，形成新的主序列， 
 *  接着缩小增量，继续对新生成的子序列进行插入排序 
 *  直到增量值为1 
 *  在这个过程中，序列变得越来越有序，而插入序列在有序的情况下效率很快 
 *  对于一个n大小的序列，如果增量为k，那么子序列为 
 *  以下为代表角标 
 *  0,...k,...2k,...3k...mk   mk<=n-1 
 *  1,...1+k,...1+2k,...1+3k,...1+mk 1+mk<=n-1 
 *  . 
 *  . 
 *  . 
 *  k-1 
 *  例 a[]=[4,2,1,5,8,7,3,6,9] k=3 
 *  子序列为 * a[0]a[3]a[6] ==> [4,5,3] 
 *  1,4,7 ==> [2,8,6] * 2,5,8 ==> [1,7,9] 
 *  
 *  时间复杂度分析 
 *  平均：O(nlogn)~O(n^2) 
 *  最好：O(n^1.3) 
 *  最坏：O(n^2) 
 *  空间复杂度：O(1) 
 *  不稳定 
 */


public class ShellSort {

    public static void shellSort(int[] datas) {


        //希尔排序开始
        //设gap为增量
        int addValue = 3;
        int gap = datas.length / addValue;
        //外循环：增量gap每次变小，直到为1
        for (; gap > 0; gap /= addValue) {
            System.out.println("gap =" + gap);
            //内循环：进行插入排序，从每个分组的第gap个元素开始，而不是从它的第一个元素开始
            for (int i = gap; i < datas.length; i++) {
                System.out.println("i =" + i);
                //如果小于前一个元素，进行交换，把小的换到前面
                if (datas[i] < datas[i - gap]) {
                    //保存小的元素
                    int temp = datas[i];
                    //记录前一个比它大的角标
                    int k = i - gap;

                    System.out.println("k1 =" + k);
                    System.out.println("k + gap" + (k + gap));
                    //如果该组元素中，前几个元素都比a[i]大，则执行后移，把比a[i]大的都移动到a[i]后面
                    while (k >= 0 && datas[k] > temp) {
                        datas[k + gap] = datas[k];
                        k -= gap;
                    }
                    System.out.println("循环中的数组" + Arrays.toString(datas));
                    //此时a[k]<a[i],a[i]放到啊a[k]右边
                    datas[k + gap] = temp;
                }
            }
        }
    }
}