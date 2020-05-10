package com.cenkc.courses.princetonalgorithms1.unionFind;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * created by cenkc on 5/10/2020
 */
public class QuickFindUF {

    private int[] id;

    /**
     * set id of each object to itself
     * (N array accesses)
     *
     * @param N
     */
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * check whether p and q are in the same component
     * (2 array accesses)
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * change all entries with id[p] to id[q]
     * (at most 2N + 2 array accesses)
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pid = id[p]; // ID that corresponds with the 1st arg
        int qid = id[q]; // ID that corresponds with the 2nd arg

        // iterate thru the whole array and look for the entries
        // whose IDs are equal to the ID of the 1st arg (pid),
        // and set those to ID of the 2nd arg (qid)
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
        printArrayLastState(p, q);
    }

    private void printArrayLastState(int p, int q) {
        System.out.println(Arrays.toString(id) + " <-- union(" + p + ", " + q + ")");
    }

    public int[] getArraySnapshot() {
        return id;
    }
}
