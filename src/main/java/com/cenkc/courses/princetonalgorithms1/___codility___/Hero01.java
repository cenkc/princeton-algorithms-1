package com.cenkc.courses.princetonalgorithms1.___codility___;

import java.util.Arrays;

/**
 * created by cenkc on 4/26/2020
 */
public class Hero01 {

    public static void main(String[] args) {
        int X = 1; //Cheese
        int Y = 1; //Tomato
        Hero01 hero01 = new Hero01();
        final int[] solution = hero01.solution(X, Y);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int X, int Y) {
        //X-> Cheese, Y-> Tomato
        int[] val = new int[2];
//        int bigBurger = Y - (2 * X);
//        int miniBurger = (4 * X) - Y;
        int miniBurger = (4 * X) - Y;//(b-2a)/2

        int bigBurger = Y - (2 * X);

        if (miniBurger < 0 || miniBurger % 2 == 1 || bigBurger < 0 || bigBurger % 2 == 1) {
            val = new int[] {0, 0};
        } else {
            val = new int[] {miniBurger / 2, bigBurger / 2};
        }
        return val;
    }
}
