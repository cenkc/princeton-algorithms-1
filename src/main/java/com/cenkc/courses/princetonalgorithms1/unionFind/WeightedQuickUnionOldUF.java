package com.cenkc.courses.princetonalgorithms1.unionFind;

import java.util.Arrays;

/**
 * Pretty much the same as QuickUnionUF.java.
 * <p>
 * <em>size[]</em> array added to hold number of objects in the tree rooted at <em>i</em>
 * and it filled with <em>1s</em> initially.
 * <p>
 * Also, union method modified to
 * <ul>
 *   <li> Link root of smaller tree to root of larger tree
 *   <li> Update the <em>size[]</em> array
 * </ul>
 *
 * Created by cenkc on 14.05.2020
 */
public class WeightedQuickUnionOldUF {

    private int id[];
    private int size[];
    private int count;

    /**
     * set id of each object to itself
     * (N array accesses)
     *
     * @param N
     */
    public WeightedQuickUnionOldUF(int N) {
        id = new int[N];
        size = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1; // not 'i', 1 (one)
        }
    }

    /**
     * chase parent pointers until reach root
     * (depth of i array accesses)
     *
     * @param i
     * @return
     */
    public int root (int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
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
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
        printArrayLastState(p, q);
    }

    private void printArrayLastState(int p, int q) {
        System.out.println(Arrays.toString(id) + " <-- union(" + p + ", " + q + "), sizes = " + getSizeArrayLastState());
    }

    public int count() { return count;}

    public int[] getArraySnapshot() {
        return id;
    }
    public String getSizeArrayLastState() {
        return Arrays.toString(size);
    }
}
