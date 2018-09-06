package com.kai.ling.leetcode.linkedlist.util;

import com.kai.ling.leetcode.linkedlist.model.Node;

import java.util.Random;

/**
 * Created by kai.wang
 * on 2018/9/6 0006.
 */

public class LinkedListUtil {

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(50);
    }

    public static void printLinkedList(Node node) {

        Node temp = node;

        while (temp != null) {
            System.out.print(temp.getData() + " , ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
