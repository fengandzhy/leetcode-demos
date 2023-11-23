package org.frank.leetcode.array.median.of.two.sorted.arrays.demo01;


/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 * */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        // 人家已经给定了从小到大排序的数组, 所以这里无需排序
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
        int[] nums = new int[length2 + length1];
        int length = length1 + length2;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < length; i++) {
            if (index2 < length2 && index1 < length1) {
                if (nums1[index1] <= nums2[index2]) {
                    nums[i] = nums1[index1];
                    index1++;
                } else {
                    nums[i] = nums2[index2];
                    index2++;
                }               
            }else if(index2 >= length2 && index1 < length1) {
                nums[i] = nums1[index1];
                index1++;
            }else if(index1 >= length1 && index2 < length2){
                nums[i] = nums2[index2];
                index2++;
            }
            // 无需将整个数组填满, 只需要过半即可, 那么既然过半就分两种情况, 奇数和偶数， 奇数肯定是最中间的那个, 偶数是中间两个数平均数
            if (length % 2 == 1 && i == length / 2) {
                return nums[i];
            }
            if (length % 2 == 0 && i == length / 2) {
                return (nums[i] + nums[i - 1]) / 2.0;
            }
        }
        return result;
    }    

    public static void main(String[] args) {
        MedianOfTwoSortedArrays arrays = new MedianOfTwoSortedArrays();
        System.out.println(arrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
