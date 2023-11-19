package org.frank.leetcode.array.next.permutation.demo01;


/**
 * https://leetcode.cn/problems/next-permutation/description/
 * */
public class NextPermutationSolution1 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index = length - 2;
        for(int i = length - 2; i>=0;i--){
            if(nums[i] >= nums[i+1]){
                index --;
            }else{
                break;
            }
        }
        
    }
}
