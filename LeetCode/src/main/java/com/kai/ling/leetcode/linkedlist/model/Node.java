package com.kai.ling.leetcode.linkedlist.model;

/**
 * Created by kai.wang
 * on 2018/9/6 0006.
 */

public class Node {

    private int data;

    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
