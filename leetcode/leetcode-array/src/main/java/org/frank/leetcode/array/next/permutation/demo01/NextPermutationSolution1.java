package org.frank.leetcode.array.next.permutation.demo01;


/**
 * https://leetcode.cn/problems/next-permutation/description/
 * 做这道题必须要搞清楚几个概念， 
 * 从右往左看, 第一次出现左边大于右边时，之前一定是升序排列， 例如 1,5,8,4,7,6,5,3,1 这个数组, 第一次出现左边大于右边就在于 4,7 这里
 * 然后7之后就是 一定是一个升序排列, 否则第一次左边大于右边的坚持不到这里. 
 * 如果7之后是降序排列, 那么第二次扫描一个大于4的数值一定是需要交换的相对较小的大值
 * 4,5 对换位置之后, 在5之后的部分，彼此互换就是升序排列
 * 
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
        if(index >= 0){ 
            int end = length - 1;
            for(int i = length -1; i>=0; i--){
                if(nums[i] > nums[index]){
                    swap(nums,index,end);
                    break;
                }else{
                    end --;
                }
            }
        }
        reverse(nums, index);       
    }
    
    // 两个互换
    public void swap(int[] nums, int index, int end){
        int temp = nums[index];
        nums[index] = nums[end];
        nums[end] = temp;
    }
    
    public void reverse(int[] nums, int index){
        int length = nums.length;
        while(index+1 <= length-1){
            int temp = nums[index+1];
            nums[index+1] = nums[length-1];
            nums[length - 1] = temp;
            index ++;
            length --;
        }
    }
}
