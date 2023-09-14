package org.frank.leetcode.dynamic.programming.pascals.triangle.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleSolution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        int number = 1;
        while (number <= numRows) {
            Integer[] intArray = new Integer[number];
            if (number == 1) {
                intArray[0] = 1;
            } else {
                List<Integer> integers = lists.get(number - 2);
                intArray[0] = 1;
                intArray[number - 1] = 1;
                for (int i = 1; i < number - 1; i++) {
                    intArray[i] = integers.get(i) + integers.get(i - 1);
                }
            }
            lists.add(Arrays.asList(intArray));
            number ++;
        }
        return lists;
    }
}
