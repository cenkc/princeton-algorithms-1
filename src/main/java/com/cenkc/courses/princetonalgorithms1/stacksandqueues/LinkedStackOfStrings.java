package com.cenkc.courses.princetonalgorithms1.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import java.util.StringTokenizer;

/**
 * created by cenkc on 5/31/2020
 */
public class LinkedStackOfStrings {

    private Node first = null;

    public static void main(String[] args) {
        String hede = "to be or not to - be - - that - - - is";
        StringTokenizer tokenizer = new StringTokenizer(hede, " ");
        LinkedStackOfStrings stackOfStrings = new LinkedStackOfStrings();
        while (tokenizer.hasMoreTokens()) {
            final String token = tokenizer.nextToken();
            if (token.equals("-")) {
                StdOut.println(stackOfStrings.pop());
            } else {
                stackOfStrings.push(token);
            }
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push (String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    private class Node {
        String item;
        Node next;
    }
}
