package com.kai.ling.leetcode.linkedlist;

import com.kai.ling.leetcode.linkedlist.model.ListNode;
import com.kai.ling.leetcode.linkedlist.util.LinkedListUtil;

/**
 * Created by kai.wang
 * on 2018/9/11 0011.
 */

public class TestLeetCodeLiskedList {

    public static void main(String[] args) {

//        ListNode node = LinkedListUtil.buildLinkedList();
//        ListNode reverseNode = Solution.recursiveReverse(node);
//        ListNode reverseNode = Solution.cycleReverse(node);
//        LinkedListUtil.printLinkedList(reverseNode);

//        int[] b = {2, 4, 6, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
//        ListNode nodeB = LinkedListUtil.buildLinkedList(b);
//
//        LinkedListUtil.printLinkedList(nodeB);
//        ListNode nodeA = nodeB;
//        for (int i = 0; i < 5; i++) {
//            nodeA = nodeA.next;
//        }
//
//        LinkedListUtil.printLinkedList(nodeA);
//
//        ListNode intersectionNode = Solution.getIntersectionNode(nodeA, nodeB);
//        LinkedListUtil.printLinkedList(intersectionNode);


        int[] b ={1};
        ListNode nodeB = LinkedListUtil.buildLinkedList(b);
        LinkedListUtil.printLinkedList(nodeB);
        ListNode listNode = Solution.removeNthFromEnd(nodeB, 1);
        LinkedListUtil.printLinkedList(listNode);
    }
}
