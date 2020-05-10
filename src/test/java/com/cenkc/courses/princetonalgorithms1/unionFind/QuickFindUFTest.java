package com.cenkc.courses.princetonalgorithms1.unionFind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by cenkc on 5/11/2020
 */
class QuickFindUFTest {

    private int N = 10;

    @BeforeEach
    public void setup() {
        // print initial state
        IntStream.range(0, N).forEach(i -> System.out.print(" " + i + " "));
        System.out.print(" <-- i");
        System.out.println();
    }

    @Test
    public void quickFindUFTest_shouldPass() {
        // given
        QuickFindUF quickFindUF = new QuickFindUF(N);

        // when
        quickFindUF.union(4,3);
        // then
        assertArrayEquals(new int[]{0, 1, 2, 3, 3, 5, 6, 7, 8, 9}, quickFindUF.getArraySnapshot());

        // when
        quickFindUF.union(3,8);
        // then
        assertArrayEquals(new int[]{0, 1, 2, 8, 8, 5, 6, 7, 8, 9}, quickFindUF.getArraySnapshot());
        assertTrue(quickFindUF.connected(8, 4));

        // when
        quickFindUF.union(6,5);
        // then
        assertArrayEquals(new int[]{0, 1, 2, 8, 8, 5, 5, 7, 8, 9}, quickFindUF.getArraySnapshot());

        // when
        quickFindUF.union(9,4);
        // then
        assertArrayEquals(new int[]{0, 1, 2, 8, 8, 5, 5, 7, 8, 8}, quickFindUF.getArraySnapshot());

        // when
        quickFindUF.union(2,1);
        // then
        assertArrayEquals(new int[]{0, 1, 1, 8, 8, 5, 5, 7, 8, 8}, quickFindUF.getArraySnapshot());
        assertTrue(quickFindUF.connected(8, 9));
        assertFalse(quickFindUF.connected(5, 0));

        // when
        quickFindUF.union(5,0);
        // then
        assertArrayEquals(new int[]{0, 1, 1, 8, 8, 0, 0, 7, 8, 8}, quickFindUF.getArraySnapshot());

        // when
        quickFindUF.union(7,2);
        // then
        assertArrayEquals(new int[]{0, 1, 1, 8, 8, 0, 0, 1, 8, 8}, quickFindUF.getArraySnapshot());

        // when
        quickFindUF.union(6,1);
        // then
        assertArrayEquals(new int[]{1, 1, 1, 8, 8, 1, 1, 1, 8, 8}, quickFindUF.getArraySnapshot());
        assertTrue(quickFindUF.connected(0, 7));
        assertFalse(quickFindUF.connected(3, 1));
    }
}