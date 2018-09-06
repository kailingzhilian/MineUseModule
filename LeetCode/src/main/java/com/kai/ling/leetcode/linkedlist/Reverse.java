package com.kai.ling.leetcode.linkedlist;

import com.kai.ling.leetcode.linkedlist.model.Node;

/**
 * Created by kai.wang
 * on 2018/9/6 0006.
 */

public class Reverse {


    public static Node recursiveReverse(Node currentNode) {
        if (currentNode == null || currentNode.getNext() == null) {
            return currentNode;
        }

        Node returnNode = recursiveReverse(currentNode.getNext());
        //这里是重点。
        //当前节点（currentNode）的下一个节点，正好是返回节点returnNode的最后一个节点
        currentNode.getNext().setNext(currentNode);
        currentNode.setNext(null);
        return returnNode;
    }


    //思路：
    //当前节点的next不为null，则需要进行反转
    //反转即：需要将next的next设置为当前节点

    public static Node cycleReverse(Node currentNode) {

        if (currentNode == null) {
            return currentNode;
        }

        //专门记录下一个节点（依次判断下个节点是否为空）
        Node nextNode = currentNode.getNext();

        //记录next的next用于下次循环使用
        Node temp;

        //准备好第一个节点（第一个节点不需要去反转）
        currentNode.setNext(null);
        Node finalNode = currentNode;//最终返回的链表

        //如果下一个几点不为空，说明还有节点，则进行反转
        while (nextNode != null) {
            //记录元素，为了指针下移
            temp = nextNode.getNext();

            //反转链表
            nextNode.setNext(finalNode);
            finalNode = nextNode;

            //指针下移
            nextNode = temp;
        }

        return finalNode;
    }

}
