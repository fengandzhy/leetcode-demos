package org.frank.leetcode.array.first.missing.positive.demo01;


import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/first-missing-positive/
 */
public class FirstMissingPositiveSolution1 {
    public int firstMissingPositive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int prevInt = list.get(0);
        if (prevInt > 1) {
            return 1;
        }
        if (list.size() == 1) {
            if (prevInt != 1) {
                return 1;
            }
            return 2;
        }
        if (list.get(list.size() - 1) < 1) {
            return 1;
        }
        for (int i = 0; i < list.size(); i++) {
            int currentInt = list.get(i);
            if (currentInt - prevInt >= 2) {
                if (currentInt < 2) {
                    prevInt = currentInt;
                } else {
                    if (prevInt > 0) {
                        return prevInt + 1;
                    } else {
                        return 1;
                    }
                }
            } else {
                prevInt = currentInt;
            }
        }
        return prevInt + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositiveSolution1 solution1 = new FirstMissingPositiveSolution1();
        solution1.firstMissingPositive(new int[]{1, 2, 0});
    }

}
