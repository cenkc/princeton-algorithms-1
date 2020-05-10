package com.cenkc.courses.princetonalgorithms1.unionFind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by cenkc on 5/11/2020
 */
class QuickUnionUFTest {

    private int N = 10;

    @BeforeEach
    public void setup() {
        // print initial state
        IntStream.range(0, N).forEach(i -> System.out.print(" " + i + " "));
        System.out.print(" <-- i");
        System.out.println();
    }

    @Test
    public void quickUnionUFTest_shouldPass() {
        // given
        QuickUnionUF quickUnionUF = new QuickUnionUF(N);

        // when
        quickUnionUF.union(4, 3);
        // then
        assertEquals(3, quickUnionUF.root(4));
        assertArrayEquals(new int[]{0, 1, 2, 3, 3, 5, 6, 7, 8, 9}, quickUnionUF.getArraySnapshot());

        // when
        quickUnionUF.union(3, 8);
        // then
        assertEquals(8, quickUnionUF.root(3));
        assertArrayEquals(new int[]{0, 1, 2, 8, 3, 5, 6, 7, 8, 9}, quickUnionUF.getArraySnapshot());

        // when
        quickUnionUF.union(6, 5);
        // then
        assertEquals(5, quickUnionUF.root(6));
        assertArrayEquals(new int[]{0, 1, 2, 8, 3, 5, 5, 7, 8, 9}, quickUnionUF.getArraySnapshot());

        // when
        quickUnionUF.union(9, 4);
        // then
        assertEquals(8, quickUnionUF.root(9));
        assertArrayEquals(new int[]{0, 1, 2, 8, 3, 5, 5, 7, 8, 8}, quickUnionUF.getArraySnapshot());

        // when
        quickUnionUF.union(2, 1);
        // then
        assertEquals(1, quickUnionUF.root(2));
        assertTrue(quickUnionUF.connected(8,9));
        assertFalse(quickUnionUF.connected(5,4));
        assertArrayEquals(new int[]{0, 1, 1, 8, 3, 5, 5, 7, 8, 8}, quickUnionUF.getArraySnapshot());

        // when
        quickUnionUF.union(5, 0);
        // then
        assertEquals(0, quickUnionUF.root(5));
        assertArrayEquals(new int[]{0, 1, 1, 8, 3, 0, 5, 7, 8, 8}, quickUnionUF.getArraySnapshot());

        // when
        quickUnionUF.union(7, 2);
        // then
        assertEquals(1, quickUnionUF.root(7));
        assertArrayEquals(new int[]{0, 1, 1, 8, 3, 0, 5, 1, 8, 8}, quickUnionUF.getArraySnapshot());

        // when
        quickUnionUF.union(6, 1);
        // then
        assertEquals(1, quickUnionUF.root(6));
        assertArrayEquals(new int[]{1, 1, 1, 8, 3, 0, 5, 1, 8, 8}, quickUnionUF.getArraySnapshot());

        // when
        quickUnionUF.union(7, 3);
        // then
        assertEquals(8, quickUnionUF.root(7));
        assertArrayEquals(new int[]{1, 8, 1, 8, 3, 0, 5, 1, 8, 8}, quickUnionUF.getArraySnapshot());
    }
}