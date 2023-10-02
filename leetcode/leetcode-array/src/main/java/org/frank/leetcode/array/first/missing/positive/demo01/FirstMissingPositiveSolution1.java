package org.frank.leetcode.array.first.missing.positive.demo01;


import java.util.*;
import java.util.stream.Collectors;

public class FirstMissingPositiveSolution1 {
    public int firstMissingPositive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        for(int i : list){
            
        }
        return 1;
    }
    
}
