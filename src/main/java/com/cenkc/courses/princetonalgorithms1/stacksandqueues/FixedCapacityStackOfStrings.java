package com.cenkc.courses.princetonalgorithms1.stacksandqueues;

/**
 * <b>Resizing array implementation pros</b> :
 *  <ul>
 *      <li>Every operation takes constant <em>amortized</em> time</li>
 *      <li>Less wasted space</li>
 *  </ul>
 *  <p>
 *  <b>Memory Usage</b>
 *  <p>
 *  Uses between ~ 8 N and ~ 32 N bytes to represent a stack with N items
 *  <ul>
 *      <li>~ 8 N when full</li>
 *      <li>~ 32 N when one-quarter full</li>
 *  </ul>
 *  <p>
 *  <i>NOTE = Analysis includes memory for the stack
 *  (but not the Strings themselves, which the client owns)</i>
 *  <p>
 *  <b>Resizing</b>
 *  <p>
 *  The <em>resize()</em> method is called only when the size of the stack
 *  is a power of 2. There are <em>~ log2  n</em> powers of 2 between 1 and <em>n</em>.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/13stacks/">Section 1.3 Stacks And Queues</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  <p>
 *  <p>
 * created by cenkc on 6/1/2020
 */
public class FixedCapacityStackOfStrings {

    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings() {
        s = new String[1];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings hede = new FixedCapacityStackOfStrings();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        // if array is full, create new array of twice the size,
        // and copy items.
        // this technique is called "repeated doubling"
        if (N == s.length) {
            resize(2 * s.length);
        }
        // use to index into array; then increment N
        s[N++] = item;
    }

    public String pop() {
        // return s[--N];
        // above implementation causes "loitering"
        // Loitering = Holding a reference to an object when it is no longer needed

        // below implementation avoids "loitering";
        // garbage collector can reclaim memory
        // only if no outstanding references
        String item = s[--N];
        s[N] = null;
        // Efficient solution to shrink the array is to
        // halve size of array s[] when array is one-quarter full
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }
}
