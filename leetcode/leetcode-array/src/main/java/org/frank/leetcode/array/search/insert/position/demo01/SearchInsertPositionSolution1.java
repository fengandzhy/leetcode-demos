package org.frank.leetcode.array.search.insert.position.demo01;

/**
 * https://leetcode.cn/problems/search-insert-position/
 */
public class SearchInsertPositionSolution1 {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        if (nums != null && nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    return i;
                }
            }
            index = nums.length;
        }
        return index;
    }
}
