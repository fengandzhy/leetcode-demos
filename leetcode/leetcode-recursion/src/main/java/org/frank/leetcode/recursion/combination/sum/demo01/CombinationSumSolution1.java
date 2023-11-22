package org.frank.leetcode.recursion.combination.sum.demo01;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumSolution1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        nestMinus(candidates,target,lists,integers);
        return null;
    }
    
    private void nestMinus(int[] candidate, int target,List<List<Integer>> lists,List<Integer> integers){
        if(target < 0){
            return;
        }
        if(target == 0){
            
        }
    }
    
    private boolean compareTwoList(List<Integer> l1, List<Integer> l2){
        int size1 = l1.size();
        int size2 = l2.size();
        if(size1 == size2 && size1 > 0){
            l1.sort((a,b) ->{
                return a -b;
            });
            l2.sort((a,b) ->{
                return a -b;
            });
            for(int i = 0; i< size1;i++){
                if(l1.get(i) != l2.get(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
