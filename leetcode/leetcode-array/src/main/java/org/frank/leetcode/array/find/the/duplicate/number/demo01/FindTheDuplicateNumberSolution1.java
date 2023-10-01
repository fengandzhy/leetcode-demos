package org.frank.leetcode.array.find.the.duplicate.number.demo01;

import java.util.Set;
import java.util.HashSet;

public class FindTheDuplicateNumberSolution1 {

    public int findDuplicate(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for(int i = 0; i< nums.length;i++){
            if(list.contains(nums[i])) {
                return nums[i];
            }
            list.add(nums[i]);
        }
        return -1;
    }
}
