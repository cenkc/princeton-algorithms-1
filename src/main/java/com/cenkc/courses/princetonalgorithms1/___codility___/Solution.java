package com.cenkc.courses.princetonalgorithms1.___codility___;

/**
 * created by cenkc on 4/29/2020
 */
class Solution {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        int K = 2;
        System.out.println(solution(A, K));
    }

    private static int solution(int[] A, int K) {

        int left = A[0];
        int right = A[A.length - 1];

        while (left <= right) {
            int middle = Math.abs((left + right)/2);
            if (middle == K) {
                return middle;
            } else if (middle >= K) {
                right = middle + 1;
            } else {
                left = middle;
            }
        }

        return 0;
    }
}