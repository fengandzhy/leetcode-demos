package org.frank.leetcode.dynamic.programming.climbing.stairs.demo02;

/**
 * 滚动数组的形式实现
 * */
public class ClimbingStairsSolution2 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
