package com.kai.ling.leetcode.sort;

import com.kai.ling.leetcode.sort.quicksort.QuickSort;
import com.kai.ling.leetcode.sort.quicksort.QuickSortOneWay;
import com.kai.ling.leetcode.sort.quicksort.QuickSortThreeWay;
import com.kai.ling.leetcode.sort.quicksort.QuickSortTwoWay;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kai.wang
 * on 2018/8/21 0021.
 */

public class TestSort {

    public static void main(String[] args) {
        int[] data = buildArray();

//        BubbleSort.bubbleSort(data);
//        SelectionSort.selectionSort(data);
//        InsertionSort.insertionSort(data);
//        ShellSort.shellSort(data);
//        QuickSort quickSort = new QuickSortOneWay();
//        QuickSort quickSort = new QuickSortTwoWay();
        QuickSort quickSort = new QuickSortThreeWay();
        quickSort.quickSort(data, 0, data.length - 1);

        System.out.println("Sort :");
        System.out.println(Arrays.toString(data));
    }

    private static int[] buildArray() {
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            Random random = new Random();
            data[i] = random.nextInt(50);
        }
        System.out.println("Random Array :");
        System.out.println(Arrays.toString(data));
        System.out.println();
        return data;
    }


}
