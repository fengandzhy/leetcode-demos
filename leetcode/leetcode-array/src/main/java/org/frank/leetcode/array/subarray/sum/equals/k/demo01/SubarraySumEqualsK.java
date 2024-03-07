package org.frank.leetcode.array.subarray.sum.equals.k.demo01;

import java.util.HashMap;
import java.util.Map;
/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/
 * */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        // 初始化，为了处理从头开始累积和正好为k的情况
        map.put(0,1);
        for(int i = 0; i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k); // 检查是否存在一个前缀和，使得当前前缀和减去该前缀和等于k
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
