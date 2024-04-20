package org.frank.leetcode.array.find.the.duplicate.number.demo01;

import java.util.Set;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/description/
 * */
public class FindTheDuplicateNumberSolution1 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length;i++){
            if(set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }    
}
