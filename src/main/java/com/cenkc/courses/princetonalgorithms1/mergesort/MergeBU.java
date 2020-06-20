package com.cenkc.courses.princetonalgorithms1.mergesort;

import java.util.Arrays;

/**
 * created by cenkc on 6/20/2020
 */
public class MergeBU {

    private static Comparable[] aux;

    public static void main(String[] args) {
        Merge merge = new Merge();
        Character[] a = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // copy a to auxiliary array aux
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz) {
            for (int lo = 0; lo < N - sz; lo += sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
