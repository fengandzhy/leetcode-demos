package org.frank.leetcode.dynamic.programming.climbing.stairs.demo01;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * 以下方案超过了时间限制, 应该是对的.
 * 
 * */
public class ClimbingStairsSolution1 {    
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n > 1){
            int a = n -1;
            int b = n -2;
            return climbStairs(a) + climbStairs(b);           
        }        
        return 1;
    }
}
