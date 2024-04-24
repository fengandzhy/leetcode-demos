package org.frank.leetcode.array.first.missing.positive.demo02;

import java.math.BigInteger;

public class FirstMissingPositiveSolution2 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Check if 1 is present in the array
        /**
         * 对于那种不含有1的数组, 那么1肯定就是缺失的最小正整数.
         * */
        boolean containsOne = false;
        for (int num : nums) {
            if (num == 1) {
                containsOne = true;
                break;
            }
        }
        if (!containsOne) return 1;

        // Step 2: Replace negative numbers, zeros, and numbers larger than n by 1s
        /**
         * 对于一个长度为n的数组来说, 一个大于n的数, 肯定不是它所缺失的最小正整数, 对于那些小于等于0的数, 肯定也不会是, 
         * 所以这里一律把它们变成1, 因为它原数组中一定含有1, 如果不含有1 上面已经return 了, 把它变成1 意思就是1绝对不可能是缺失的最小整数.
         * */
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // Step 3: Transform array using index as hash key
        /**
         * 这里就是最难以理解的一步了, 剩下的 长度为n 的数组, 小于等于0 的被改成了 1, 大于n 的也被改成了 1, 
         * 剩下的这长度为n 的数组, 基本上就是 1 到 n 范围内取值, 然后对于这些数值做筛选, 如何做筛选呢, 比方说 [1,2,4] 这个数组,
         * 经过前两轮的筛选 到这里就变成了[1,2,1],然后做进一步筛选, 变成了 [1,-2,-1], 因为数组的下标为0开始, 而数组的取值范围是 1 到 n, 包含 n 
         * 所以如下的循环要从 1 开始, 注意它返回的是没有被映射到的下标, 例如 [1,3,4] 这个数组, 经过前两轮的筛选 变成了 [1,3,1], 
         * 经过了本轮的筛选变成了 [-1,-3, 1] 由于下面那个循环从 1 开始, 它下标为 2 的这个元素没有被绝对值筛选变成负值, 因此它缺失的最小正整数为 2 
         * 
         * */
        for (int i = 0; i < n; ++i) {
            int a = Math.abs(nums[i]);
            if (a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }

        // Step 4: Determine the first missing positive integer
        for (int i = 1; i < n; ++i) {
            if (nums[i] > 0)
                return i;
        }

        /**
         * [1,2,4] 这个数组, 最小的缺失正整数是3 0 - n-1 这个下标里, 含有 1 - n 这些数字中 在上面所有的下标都被替换了, 唯独没有  nums[0] 被替换, 所以最小的缺失正整数是 3 
         * 
         * */
        if (nums[0] > 0)
            return n;

        return n + 1;    
    }

    public static void main(String[] args) {        
//        int[] nums = {-2,5,7,6,9,3,8,9,4,1};
//        int[] nums = {1,3,4};
//        FirstMissingPositiveSolution2 solution2 = new FirstMissingPositiveSolution2();
//        solution2.firstMissingPositive(nums);

        
    }
}
