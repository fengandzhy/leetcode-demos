package org.frank.leetcode.array.search.insert.position.demo03;

/**
 * https://leetcode.cn/problems/search-insert-position/
 * 二分法查找
 * 
 * 初始化两个指针，left为0（数组的起始位置）和right为nums.length - 1（数组的末尾位置）。
 *
 * 当left <= right时，执行循环：
 *
 * 计算中点mid = left + (right - left) / 2。
 * 如果nums[mid]正好等于target，那么mid就是要找的索引，直接返回mid。
 * 如果nums[mid]小于target，说明目标值在中点的右侧，将left调整为mid + 1。
 * 如果nums[mid]大于target，说明目标值在中点的左侧，将right调整为mid - 1。
 * 循环结束时，如果没有找到目标值，left指针将指向目标值应该插入的位置。因为循环终止条件是left超过了right，此时left正好是目标值按顺序插入的位置。
 */
public class SearchInsertPositionSolution3 {
    public int searchInsert(int[] nums, int target) {
        if(null != nums){
            int left = 0;
            int right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(target == nums[mid]){
                    return mid;
                }
                if(target < nums[mid]){
                    right = mid - 1;
                }
                
                if(target > nums[mid]){
                    left = mid + 1;
                }
            }
            return left;
        }
        return 0;
    }
}
