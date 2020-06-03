package com.cenkc.courses.princetonalgorithms1.stacksandqueues;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * for intellij,
 * Run -> Edit Configurations -> Program arguments
 * insert "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"
 *
 * created by cenkc on 6/3/2020
 */
public class DijkstrasTwoStackAlgorithm {

    public static void main(String[] args) {
        Stack<String> operators = new Stack<>();
        Stack<Double> values = new Stack<>();
//        while ( ! StdIn.isEmpty()) {
        for (int i = 0; i < args.length; i++) {
//            final String s = StdIn.readString();
            String s = args[i];
            if (s.equals("(")) {;}
            else if (s.equals("+")) {operators.push(s);}
            else if (s.equals("*")) {operators.push(s);}
            else if (s.equals(")")) {
                String operator = operators.pop();
                if (operator.equals("+")) {values.push(values.pop() + values.pop());}
                else if (operator.equals("*")) {values.push(values.pop() * values.pop());}
            }
            else {values.push(Double.parseDouble(s));}
        }
        StdOut.println(values.pop());
    }
}
