package org.frank.leetcode.array.search.insert.position.demo02;

/**
 * https://leetcode.cn/problems/search-insert-position/
 */
public class SearchInsertPositionSolution2 {
    public int searchInsert(int[] nums, int target) {
        if(nums != null){
            int length = nums.length;
            for(int i = 0; i < length; i++ ){
                if(nums[i] >= target){
                    return i;
                }
            }
            return length;
        }        
        return 0;
    }
}
