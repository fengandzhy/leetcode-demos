package org.frank.leetcode.recursion.combination.sum.demo01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSumSolution1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();        
        if(candidates== null || candidates.length == 0){
            return lists;
        }
        int length = candidates.length;
        Deque<Integer> deque = new ArrayDeque<>(length);
        dfs(candidates,0,length,target,lists,deque);
        return lists;
    }
    
    private void dfs(int[] candidates, int begin, int length, int target, List<List<Integer>> lists, Deque<Integer> deque){
        if(target < 0){
            return;
        }
        if(target == 0){
            List<Integer> integers = new ArrayList<>(deque);
            lists.add(integers);
            return;
        }
        for(int i = begin; i<length; i++){
            deque.addLast(candidates[i]);
            dfs(candidates,i,length,target-candidates[i],lists,deque);
            deque.removeLast();
        }
    }    
}
