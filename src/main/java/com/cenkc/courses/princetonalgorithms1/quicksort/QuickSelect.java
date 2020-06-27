package com.cenkc.courses.princetonalgorithms1.quicksort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Goal. Given an array of N items, find a k th smallest item.
 * Ex. Min (k = 0), max (k = N - 1), median (k = N/ 2)
 *
 * created by cenkc on 6/28/2020
 */
public class QuickSelect {

    public static void main(String[] args) {
        Character[] a = {'Q','U','I','C','K','S','O','R','T','E','X','A','M','P','L','E'};
        final Comparable select = select(a, 1); // should return 'C'
        System.out.println(select);
        // sorted : [A, C, E, E, I, K, L, M, O, P, Q, R, S, T, U, X]
    }

    public static Comparable select(Comparable[] a, int k)
    {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            // find item on left to swap
            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }
            // find item on left to swap
            while (less(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            //check if pointers cross
            if (i >= j) {
                break;
            }
            //swap
            exch(a, i, j);
        }
        // swap with partitioning item
        exch(a, lo, j);
        // return index of item now known to be in place
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
