package com.kai.ling.leetcode.linkedlist.util;

import com.kai.ling.leetcode.linkedlist.model.ListNode;

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

    public static void printLinkedList(ListNode node) {
        ListNode temp = node;

        while (temp != null) {
            System.out.print(temp.val + " , ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static ListNode buildLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        printLinkedList(head);
        return head;
    }

    public static ListNode buildLinkedList() {
        ListNode head = new ListNode(getRandomNumber());
        ListNode temp = head;
        ListNode next;
        for (int i = 0; i < 10; i++) {
            next = new ListNode(getRandomNumber());
            temp.next = next;
            temp = next;
        }

        printLinkedList(head);
        return head;
    }
}
