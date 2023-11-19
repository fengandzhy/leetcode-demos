package org.frank.leetcode.array.search.in.rotated.sorted.array.demo01;

public class SearchInRotatedSortedArraySolution1 {
    public int search(int[] nums, int target) {
        if(nums[0] > target){
           for(int i = nums.length -1; i>=0; i--){
               if(nums[i] == target){
                   return i;
               }
               if(i > 0 && nums[i] < nums[i-1]){
                   break;
               }
           }
        }else{
            for(int i = 0; i<nums.length;i++){
                if(nums[i] == target){
                    return i;
                }
                if(i<nums.length-2 && nums[i] > nums[i+1]){
                    break;
                }
            }
        }
        return -1;
    }
}
