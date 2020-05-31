package com.cenkc.courses.princetonalgorithms1.unionFind;

import java.util.Arrays;

/**
 * created by cenkc on 5/10/2020
 */
public class QuickUnionPathCompressionUF {

    private int id[];

    /**
     * set id of each object to itself
     * (N array accesses)
     *
     * @param N
     */
    public QuickUnionPathCompressionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * chase parent pointers until reach root
     * (depth of i array accesses)
     *
     * @param i
     * @return
     */
    int root (int i) {
        int root = i;
       while (root != id[root]) {
           root = id[root];
       }
       while (i != root) {
           int new_i = id[i];
           id[i] = root;
           i = new_i;
       }
       return root;
    }

    /**
     * check if p and q have same root
     * (depth of p and q array accesses)
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }

    /**
     * change root of p to point to root of q
     * (depth of p and q array accesses)
     *
     * @param p
     * @param q
     */
    public void union (int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
        printArrayLastState(p, q);
    }

    private void printArrayLastState(int p, int q) {
        System.out.println(Arrays.toString(id) + " <-- union(" + p + ", " + q + ")");
    }

    public int[] getArraySnapshot() {
        return id;
    }
}
