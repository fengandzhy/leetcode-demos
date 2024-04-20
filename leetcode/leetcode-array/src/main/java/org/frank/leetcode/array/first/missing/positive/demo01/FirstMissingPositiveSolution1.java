package org.frank.leetcode.array.first.missing.positive.demo01;


import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/first-missing-positive/
 */
public class FirstMissingPositiveSolution1 {
    public int firstMissingPositive(int[] nums) {
        // 第一步先排序
        Arrays.sort(nums);
//        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
//        nums Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
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
            // 后数减去前数如果跨度超越了2 就要分两种情况来讨论
            if (currentInt - prevInt >= 2) {
                // 如果 currentInt < 2 要么 currentInt 还没到1 要么 currentInt 已经是1 
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
