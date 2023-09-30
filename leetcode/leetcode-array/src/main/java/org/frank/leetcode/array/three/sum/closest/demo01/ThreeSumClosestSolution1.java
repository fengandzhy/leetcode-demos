package org.frank.leetcode.array.three.sum.closest.demo01;

/**
 * https://leetcode.cn/problems/3sum-closest/
 * */
public class ThreeSumClosestSolution1 {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int distance = 0;
        if(nums != null && nums.length > 0){
            for(int i = 0; i < nums.length-2; i++){                
                for(int j = i+1; j<nums.length-1; j++ ){                    
                    for(int n = j+1; n < nums.length; n++){
                        int sum = nums[i] + nums[j] + nums[n];
                        if(sum == target){
                            return sum;
                        }
                        int tempDistance = 0;
                        if(sum < target){
                            tempDistance = target - sum;
                        }else{
                            tempDistance = sum - target;
                        }
                        if(distance == 0 || distance > tempDistance ){
                            distance = tempDistance;
                            closestSum = sum;
                        }
                    }
                }                
            }
        }        
        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosestSolution1 solution1 = new ThreeSumClosestSolution1();
        solution1.threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }
}
