package com.kai.ling.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kai.wang
 * on 2018/8/21 0021.
 */

public class TestSort {

    public static void main(String[] args) {
        int[] data = buildArray();

        BubbleSort.bubbleSort(data);

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