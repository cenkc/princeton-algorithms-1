package com.cenkc.courses.princetonalgorithms1.elementarysorts;

/**
 * for animation and other useful information :
 * https://www.toptal.com/developers/sorting-algorithms/insertion-sort
 *
 * created by cenkc on 6/15/2020
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        String[] hede = new String[] {"ali", "veli", "kirkdokuz", "elli"};
        for (String s : hede) {
            System.out.println("s = " + s);
        }
        sort(hede);
        for (String s : hede) {
            System.out.println("s = " + s);
        }
    }
}
