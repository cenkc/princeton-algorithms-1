package com.cenkc.courses.princetonalgorithms1.stacksandqueues;

/**
 * Created by cenkc on 1.06.2020
 */
public class LinkedQueueOfStrings {

    private Node first, last;

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    private String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    private class Node {
        String item;
        Node next;
    }
}
