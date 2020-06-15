package com.cenkc.courses.princetonalgorithms1.elementarysorts;

/**
 * Shell Sort covered in https://www.udemy.com/course/data-structures-and-algorithms-deep-dive-using-java
 *
 * Variation of Insertion Sort.
 * While Insertion Sort chooses which element to insert using a gap of 1,
 * Shell Sort starts out using a larger gap value and as the algorithm runs,
 * the gap is reduced. The goal is to reduce the amount of shifting required.
 *
 * The last gap value is always 1
 * A gap value of 1 equivalent to Insertion Sort
 * So, the algorithm does some preliminary work (using gap values greater than 1),
 * and then becomes Insertion Sort
 *
 * By the time we get to Insertion Sort, the array has been partially sorted,
 * so there's less shifting required.
 *
 * In-place and unstable algorithm.
 *
 * Worst case Quadratic, O(n²), but it can perform much better than that
 *
 * created by cenkc on 6/15/2020
 */
public class ShellAlt {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                int j = i;
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = newElement;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
