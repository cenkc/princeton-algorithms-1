package com.cenkc.courses.princetonalgorithms1.amazon.amcat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Amazon AMCAT Demo Test
 *
 * Eight houses represented as cellsi are arranged in a straight line.
 * Each day every cell competes its adjacent cells (neighbors).
 * An integer value of 1 represents an active cell
 * and a value of 0 represents an inactive cell.
 * If the neighbors on both the sides of a cell are either active or inactive,
 * the cell becomes inactive on the next day, otherwise the cell becomes active.
 *
 * The two cells on each end have a single adjacent cell,
 * so assume that the unoccupied space on the opposite side is an inactive cell.
 * Even after updating the cell state, consider its previous state when updating
 * the state of other cells. The state information of all cells should be updated  simultaneously.
 *
 * Write an algorithm to output the state of the cells after the given number of days.
 *
 * Input
 * The input to the function/method consists of two arguments:
 * states, a list of integers representing the current state of cells;
 * days, an integer representing the number of days.
 *
 * Output
 * Return a list of integers representing the state of the cells after the given number of days.
 *
 * Note
 * The elements of the list states contains 0s and 1s only.
 *
 * -----------------------------------
 * Testcase 1:
 * Input:
 * [1, 0, 0, 0, 0, 1, 0, 0], 1
 *
 * Expected Return Value:
 * 0, 1, 0, 0, 1, 0, 1, 0
 * -----------------------------------
 * Testcase 2:
 * Input:
 * [1, 1, 1, 0, 1, 1, 1, 1], 2
 *
 * Expected Return Value:
 * 0 0 0 0 0 1 1 0
 * -----------------------------------
 *
 * created by cenkc on 8/11/2020
 */
public class EightHouses {

    /**
     * It is similar to PrisonCellsAfterNDays problem
     * But watch-out for the explanation about
     *
     * @param states
     * @param days
     * @return
     */
    public List<Integer> cellCompete(int[] states, int days) {

        //int cycleDay = ((days-1)%14)+1;
        int[] result = new int[states.length];
        for(int day = 0; day < days; day++) {
            for (int i = 1; i < states.length - 1; i++) {
                if (states[i-1] == states[i+1]) {
                    result[i] = 0;
                } else {
                    result[i] = 1;
                }
            }
            //System.arraycopy(result, 0, states, 0, states.length);
            states = Arrays.copyOf(result, states.length);
        }
        //return states;
        List<Integer> hede = new ArrayList<>();
        for (int i = 0; i < states.length; i++) {
            hede.add(states[i]);
        }
        System.out.println(hede.toString());
        return hede;
    }

    public static void main(String[] args) {
        //int N = 1;
        ////int[] cells = new int[]{0,1,0,1,1,0,0,1};
        //final int[] later = cellsAfterNDays.cellCompete(cells, N);
        //System.out.println(Arrays.toString(later));

        int N = 2;
        //int[] cells = new int[]{1,0,0,0,0,1,0,0};
        int[] cells = new int[]{1,1,1,0,1,1,1,1};
        EightHouses cellsAfterNDays = new EightHouses();
        final List<Integer> later = cellsAfterNDays.cellCompete(cells, N);
        System.out.println(later.toString());
    }
}
