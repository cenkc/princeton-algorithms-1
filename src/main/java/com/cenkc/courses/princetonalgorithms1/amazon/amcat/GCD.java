package com.cenkc.courses.princetonalgorithms1.amazon.amcat;

/**
 * Amazon AMCAT Demo Test
 *
 * The greatest common divisor (GCD), also called highest common factor (HFC)
 * of N numbers is the largest poisitive integer that divides all numbers without
 * giving a remainder.
 *
 * Write an algorithm to determine the GCD of N positive integers (N).
 *
 * Input
 * The input of the function/method consists of two arguments -
 * num, an integer representing the number of positive integers (N).
 * arr, a list of positive integers
 *
 * Output
 * Return an integer representing the GCD of the given positive integers.
 *
 * Example
 * Input:
 * num = 5
 * arr = [2, 4, 6, 8, 10]
 * Output:
 * 2
 * Explanation:
 * The largest positive integer that divides all the positive integers 2, 4, 6, 8, 10
 * without a remainder is 2.
 * So, the output is 2.
 *
 * -----------------------------------
 * Testcase 1:
 * Input:
 * 5,
 * [2, 3, 4, 5, 6]
 *
 * Expected Return Value:
 * 1
 * -----------------------------------
 Testcase 1:
 * Input:
 * 5,
 * [2, 4, 6, 8, 10]
 *
 * Expected Return Value:
 * 2
 * -----------------------------------
 *
 * created by cenkc on 8/11/2020
 */
public class GCD {

    public static void main(String[] args) {
        int num = 5;
        int[] arr = new int[] {2,4,6,8,10};
        GCD gcd = new GCD();
        System.out.println("result: " + gcd.generalizedGCD(num, arr));
    }

    public int generalizedGCD(int num, int[] arr) {
        int result = 0;
        for (int element : arr) {
            result = gcd(result, element);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
