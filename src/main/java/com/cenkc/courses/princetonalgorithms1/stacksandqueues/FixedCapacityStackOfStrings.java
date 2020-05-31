package com.cenkc.courses.princetonalgorithms1.stacksandqueues;

/**
 * created by cenkc on 6/1/2020
 */
public class FixedCapacityStackOfStrings {

    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
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
        return item;
    }
}
