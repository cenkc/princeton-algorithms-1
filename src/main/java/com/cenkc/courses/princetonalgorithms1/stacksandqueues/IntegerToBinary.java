package com.cenkc.courses.princetonalgorithms1.stacksandqueues;

import edu.princeton.cs.algs4.Stack;

/**
 * created by cenkc on 6/3/2020
 */
public class IntegerToBinary {

    public static void main (String[] args) {
        int n = 299;
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }

        for (int digit : stack) {
            System.out.print(digit);
        }
        System.out.println();
    }
}
