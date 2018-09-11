package com.kai.ling.leetcode.linkedlist;

import com.kai.ling.leetcode.linkedlist.model.ListNode;

/**
 * Created by kai.wang
 * on 2018/9/7 0007.
 */


public class Solution {

    /**
     * 查找单向链表中是否有环
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回单向链表中环的入口
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                break;
            }
        }

        while (head != null && slow != null) {
            if (head.equals(slow)) {
                return slow;
            }
            head = head.next;
            slow = slow.next;
        }

        return null;

    }

    /**
     * 返回相交单向链表的交点
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        //记录链表的长度
        int lenA = 1;
        ListNode tempA = headA;
        while (tempA.next != null) {
            lenA++;
            tempA = tempA.next;
        }

        int lenB = 1;
        ListNode tempB = headB;
        while (tempB.next != null) {
            lenB++;
            tempB = tempB.next;
        }

        //判断链表是否相交，不想交直接返回null
        if (!tempA.equals(tempB)) {
            return null;
        }

        //截取后半段，相同长度的链表
        int reduseCount = lenA - lenB;

        tempA = headA;
        tempB = headB;
        if (reduseCount > 0) {
            for (int i = 0; i < reduseCount; i++) {
                tempA = tempA.next;
            }
        } else {
            reduseCount = Math.abs(reduseCount);
            for (int i = 0; i < reduseCount; i++) {
                tempB = tempB.next;
            }
        }

        //循环遍历找到交点
        while (tempB != null && tempA != null) {
            if (tempB.equals(tempA)) {
                return tempB;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }


    /**
     * 递归反转单向链表
     */
    public static ListNode recursiveReverse(ListNode currentNode) {
        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        }

        ListNode returnNode = recursiveReverse(currentNode.next);
        //这里是重点。
        //当前节点（currentNode）的下一个节点，正好是返回节点returnNode的最后一个节点
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return returnNode;
    }


    /**
     * 正向反转单向链表
     */
    public static ListNode cycleReverse(ListNode currentNode) {
        //思路：
        //当前节点的next不为null，则需要进行反转
        //反转即：需要将next的next设置为当前节点

        if (currentNode == null) {
            return currentNode;
        }

        //专门记录下一个节点（依次判断下个节点是否为空）
        ListNode nextNode = currentNode.next;

        //记录next的next用于下次循环使用
        ListNode temp;

        //准备好第一个节点（第一个节点不需要去反转）
        currentNode.next = null;
        ListNode finalNode = currentNode;//最终返回的链表

        //如果下一个几点不为空，说明还有节点，则进行反转
        while (nextNode != null) {
            //记录元素，为了指针下移
            temp = nextNode.next;

            //反转链表
            nextNode.next = finalNode;
            finalNode = nextNode;

            //指针下移
            nextNode = temp;
        }

        return finalNode;
    }
}

