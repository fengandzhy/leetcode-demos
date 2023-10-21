package org.frank.leetcode.array.four.sum.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sum/description/
 */

public class FourSumSolution1 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if (length < 4) {
            return list;
        }
        Arrays.sort(nums);
        if ((long)nums[length - 4] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
            return list;
        }
        if ((long)nums[0] + nums[1] + nums[2] + nums[3] > target) {
            return list;
        }
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            if ((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }
            if ((long)first + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int second = nums[j];
                if((long)first + second + nums[j + 1] + nums[j + 2] > target ){
                    break;
                }
                if((long)first + second + nums[length - 2] + nums[length - 1] < target){
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while(left < right){
                    long sum = (long)first + second + nums[left] + nums[right];
                    if(sum == target){
                        list.add(Arrays.asList(first,second,nums[left],nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (sum < target) {
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FourSumSolution1 solution1 = new FourSumSolution1();
        solution1.fourSum(new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000}, 1000000000);
    }
}



