package com.cenkc.courses.princetonalgorithms1.amazon.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cenkc on 7/31/2020
 */
public class Test {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(4);
        list.add(l1);

        for(List<Integer> l : list) {
            System.out.println(l.toString());
        }
    }
}
