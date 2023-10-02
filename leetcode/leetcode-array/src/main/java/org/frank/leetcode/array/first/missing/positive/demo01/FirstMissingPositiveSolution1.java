package org.frank.leetcode.array.first.missing.positive.demo01;


import java.util.*;
import java.util.stream.Collectors;

public class FirstMissingPositiveSolution1 {
    public int firstMissingPositive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int prevInt = list.get(0);
        if(prevInt > 1){
            return 1;
        }
        if(list.size() == 1){
            if(prevInt != 1){
                return 1;
            }
            return 2;
        }
        if(list.get(list.size() -1) < 1){
            return 1;
        }
        int[] signs = new int[list.get(list.size()-1)];        
        for (int i = 0; i < list.size(); i++) {
            int currentInt = list.get(i);
            if(currentInt > 0){
                signs[currentInt-1] = 1;                
            }
        }
        int index = 0;
        for(int i = 0; i< signs.length; i ++){
            index = i+1;
            if(signs[i] == 0){
                return i+1;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositiveSolution1 solution1 = new FirstMissingPositiveSolution1();
        solution1.firstMissingPositive(new int[]{1,2,0});
    }
    
}
