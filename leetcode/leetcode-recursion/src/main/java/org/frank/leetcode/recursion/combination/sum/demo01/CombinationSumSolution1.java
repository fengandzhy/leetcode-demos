package org.frank.leetcode.recursion.combination.sum.demo01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * https://leetcode.cn/problems/combination-sum/description/
 * 
 * */
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
        // 重点理解这里从 begin 开始搜索的语意
        for(int i = begin; i<length; i++){
            deque.addLast(candidates[i]);
            
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates,i,length,target-candidates[i],lists,deque);
            deque.removeLast();
        }
    }    
}
