package com.kai.ling.leetcode.linkedlist;

import com.kai.ling.leetcode.linkedlist.model.Node;
import com.kai.ling.leetcode.linkedlist.util.LinkedListUtil;

/**
 * Created by kai.wang
 * on 2018/9/6 0006.
 */

public class TestLinkedList {

    public static void main(String[] args) {
        Node node = buildLinkedList();
//        Node reverseNode = Reverse.recursiveReverse(node);
        Node reverseNode = Reverse.cycleReverse(node);
        LinkedListUtil.printLinkedList(reverseNode);
    }

    private static Node buildLinkedList() {
        Node head = new Node(LinkedListUtil.getRandomNumber());
        Node temp = head;
        Node next;
        for (int i = 0; i < 10; i++) {
            next = new Node(LinkedListUtil.getRandomNumber());
            temp.setNext(next);
            temp = next;
        }

        LinkedListUtil.printLinkedList(head);
        return head;
    }


}
