package com.cenkc.courses.princetonalgorithms1.elementarysorts;

/**
 * SelectionSort covered in https://www.udemy.com/course/data-structures-and-algorithms-deep-dive-using-java
 *
 * created by cenkc on 6/15/2020
 */
public class SelectionAlt {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastSortedIndex = intArray.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastSortedIndex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, largest, lastSortedIndex);
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void swap (int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
