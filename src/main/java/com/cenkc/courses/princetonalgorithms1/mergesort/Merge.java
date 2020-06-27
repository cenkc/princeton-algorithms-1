package com.cenkc.courses.princetonalgorithms1.mergesort;

import java.util.Arrays;

/**
 * Divide array into two halves, recursively sort each half and then merge two halves
 *
 * for animation and other useful information :
 * https://www.toptal.com/developers/sorting-algorithms/merge-sort
 *
 * created by cenkc on 6/20/2020
 */
public class Merge {

    public static void main(String[] args) {
        Character[] a = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        // Stop if already sorted :
        // Is biggest item inf first half <= smallest item in second half?
        if (!less(a[mid + 1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);        // precondition : a[lo..mid] sorted
        assert isSorted(a, mid+1, hi);   // precondition : a[mid+1..hi] sorted

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
        assert isSorted(a, lo, hi);         // postcondition : a[lo..hi] sorted
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}
