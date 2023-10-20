package org.frank.leetcode.array.four.sum.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sum/description/
 * */

public class FourSumSolution1 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if(length < 4){
            return list;
        }
        for(int i = 0; i < length; i++){
            List<Integer> tempList = new ArrayList<>();
            boolean isFound = false;
            int first = nums[i];            
            int tempTarget1 = target - first;
            for(int j = i + 1; j < length; j ++){
                int second = nums[j];                
                int tempTarget2 = tempTarget1 - second;
                for(int m = j + 1; m < length; m ++){
                    int third = nums[m];                    
                    int tempTarget3 = tempTarget2 - third;
                    for(int n = m+1; n < length; n ++){
                        int forth = nums[n];
                        if(forth == tempTarget3){
                            tempList.add(first);
                            tempList.add(second);
                            tempList.add(third);
                            tempList.add(forth);
                            isFound = true;
                        }
                        if(isFound){
                            break;
                        }
                    }
                    if(isFound){
                        break;
                    }
                }
                if(isFound){
                    break;
                }                
            }
            tempList.sort((a, b)-> {
                return a.compareTo(b);
            });
            if(!isExist(list,tempList )){
                list.add(tempList);
            }
        }
        return list;
    }
    
    private boolean isExist(List<List<Integer>> list, List<Integer> tempList ){
        if(list.size() == 0){
            return false;
        }
        for(List<Integer> integers: list){
            for(int i = 0; i < tempList.size(); i ++){
                if(integers.get(i) != tempList.get(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
