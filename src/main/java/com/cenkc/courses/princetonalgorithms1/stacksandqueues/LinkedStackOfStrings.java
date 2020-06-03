package com.cenkc.courses.princetonalgorithms1.stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import java.util.StringTokenizer;

/**
 * <b>Linked List implementation pros</b> :
 *  <ul>
 *      <li>Every operation takes constant time in the <em>worst case</em></li>
 *      <li>Uses extra time and space to deal with the links</li>
 *  </ul>
 *  <p>
 *  <b>Memory Usage</b>
 *  <p>
 *  A stack with N items uses ~ 40 N bytes
 *  <ul>
 *      <li>16 bytes Object overhead</li>
 *      <li>8 bytes (inner class extra overhead)</li>
 *      <li>8 bytes reference to String</li>
 *      <li>8 bytes reference to Node</li>
 *      <li>TOTAL : 40 bytes per stack Node</li>
 *  </ul>
 *  <p>
 *  <i>NOTE = This accounts for the memory for the stack
 *  (but not the memory for Strings themselves, which the client owns)</i>
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/13stacks/">Section 1.3 Stacks And Queues</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  <p>
 *  <p>
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
