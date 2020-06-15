package com.cenkc.courses.princetonalgorithms1.elementarysorts;

/**
 * Insertion Sort covered in https://www.udemy.com/course/data-structures-and-algorithms-deep-dive-using-java
 *
 * created by cenkc on 6/15/2020
 */
public class InsertionAlt {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;
            // traversing the sorted partition and doing the comparisons from right to left
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
