package org.frank.leetcode.array.find.pivot.index.demo01;

/**
 * https://leetcode.cn/problems/find-pivot-index/description/
 * */
public class FindPivotIndexSolution1 {

    public int pivotIndex(int[] nums) {
        int length = nums.length;        
        int left = 0;
        int right = 0;
        for(int i = 0; i < length; i++){
            right = right + nums[i];
        }        
        int index = 0;
        while(true){
            if(index > length - 1){
                break;
            }                  
            if(index > 0){
                left = left + nums[index -1];
            }            
            right = right - nums[index];
            if(left == right){
                return index;
            }
            index ++;
        }        
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndexSolution1 solution1 = new FindPivotIndexSolution1();
        solution1.pivotIndex(new int[]{1,7,3,6,5,6});
    }
}
