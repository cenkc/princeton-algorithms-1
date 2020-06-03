package com.cenkc.courses.princetonalgorithms1.stacksandqueues;

/**
 * created by cenkc on 6/3/2020
 */
public class Stack<E> {

    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(E item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public E pop() {
        E item = first.item;
        first = first.next;
        return item;
    }

    private class Node {
        E item;
        Node next;
    }
}
