package com.cenkc.courses.princetonalgorithms1.___codility___;

/**
 * created by cenkc on 4/26/2020
 */
public class Hero02 {

    public static void main(String[] args) {
//        int[] A = new int[]{1, 2, 3, 10, 11, 15};
//        int[] A = new int[]{4,5,6,-4,-3,-2,-1,0,2,3};
        int[] A = new int[]{1, 3, 4, -7, -8, -9, -10, -11, 12, 11}; //5
//        1, 3, 4, -7, -8, -9, -10, -11, 12, 11 //5
        Hero02 hero02 = new Hero02();
        System.out.println(hero02.solution(A));
    }

    public int solution(int[] A) {
        int last = Integer.MIN_VALUE;
        int maxNumSeries = 0;
        int currNumSeries = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == last + 1) {
                currNumSeries++;
                maxNumSeries = Math.max(maxNumSeries, currNumSeries);
            } else if (A[i] == last - 1) {
                currNumSeries++;
                maxNumSeries = Math.max(maxNumSeries, currNumSeries);
            } else {
                currNumSeries = 1;
            }
            last = A[i];
        }
        return Math.max(maxNumSeries, currNumSeries);
    }
}
