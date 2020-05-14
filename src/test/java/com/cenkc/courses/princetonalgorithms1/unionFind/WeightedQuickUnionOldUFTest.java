package com.cenkc.courses.princetonalgorithms1.unionFind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by cenkc on 14.05.2020
 */
class WeightedQuickUnionOldUFTest {

    private int N = 10;

    @BeforeEach
    public void setup() {
        // print initial state
        IntStream.range(0, N).forEach(i -> System.out.print(" " + i + " "));
        System.out.print(" <-- i");
        System.out.println();
    }

    @Test
    public void weightedQuickUnionOldUFTest_shouldPass() {
        // given
        WeightedQuickUnionOldUF weightedQuickUnionOldUF = new WeightedQuickUnionOldUF(N);

        // when
        weightedQuickUnionOldUF.union(4, 3);
        // then
        assertEquals(4, weightedQuickUnionOldUF.root(3));
        assertArrayEquals(new int[] {0, 1, 2, 4, 4, 5, 6, 7, 8, 9}, weightedQuickUnionOldUF.getArraySnapshot());

        // when
        weightedQuickUnionOldUF.union(3, 8);
        // then
        assertEquals(4, weightedQuickUnionOldUF.root(8));
        assertArrayEquals(new int[] {0, 1, 2, 4, 4, 5, 6, 7, 4, 9}, weightedQuickUnionOldUF.getArraySnapshot());

        // when
        weightedQuickUnionOldUF.union(6, 5);
        // then
        assertEquals(6, weightedQuickUnionOldUF.root(5));
        assertArrayEquals(new int[] {0, 1, 2, 4, 4, 6, 6, 7, 4, 9}, weightedQuickUnionOldUF.getArraySnapshot());

        // when
        weightedQuickUnionOldUF.union(9, 4);
        // then
        assertEquals(4, weightedQuickUnionOldUF.root(9));
        assertArrayEquals(new int[] {0, 1, 2, 4, 4, 6, 6, 7, 4, 4}, weightedQuickUnionOldUF.getArraySnapshot());

        // when
        weightedQuickUnionOldUF.union(2, 1);
        // then
        assertEquals(2, weightedQuickUnionOldUF.root(1));
        assertArrayEquals(new int[] {0, 2, 2, 4, 4, 6, 6, 7, 4, 4}, weightedQuickUnionOldUF.getArraySnapshot());

        // when
        weightedQuickUnionOldUF.union(5, 0);
        // then
        assertEquals(6, weightedQuickUnionOldUF.root(0));
        assertArrayEquals(new int[] {6, 2, 2, 4, 4, 6, 6, 7, 4, 4}, weightedQuickUnionOldUF.getArraySnapshot());

        // when
        weightedQuickUnionOldUF.union(7, 2);
        // then
        assertEquals(2, weightedQuickUnionOldUF.root(7));
        assertArrayEquals(new int[] {6, 2, 2, 4, 4, 6, 6, 2, 4, 4}, weightedQuickUnionOldUF.getArraySnapshot());

        // when
        weightedQuickUnionOldUF.union(6, 1);
        // then
        assertEquals(6, weightedQuickUnionOldUF.root(1));
        assertArrayEquals(new int[] {6, 2, 6, 4, 4, 6, 6, 2, 4, 4}, weightedQuickUnionOldUF.getArraySnapshot());

        // when
        weightedQuickUnionOldUF.union(7, 3);
        // then
        assertEquals(6, weightedQuickUnionOldUF.root(3));
        assertArrayEquals(new int[] {6, 2, 6, 4, 6, 6, 6, 2, 4, 4}, weightedQuickUnionOldUF.getArraySnapshot());
    }
}