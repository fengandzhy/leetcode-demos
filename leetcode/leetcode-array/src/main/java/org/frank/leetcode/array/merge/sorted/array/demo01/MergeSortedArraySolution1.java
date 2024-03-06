package org.frank.leetcode.array.merge.sorted.array.demo01;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArraySolution1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        List<Integer> mergedArray = new ArrayList<>(); 
        while(m > 0 && n > 0){
            int temp1 = nums1[index1];
            int temp2 = nums2[index2];
            if(temp1 <= temp2){
                mergedArray.add(temp1);
                m = m -1;
                index1++;
            }else{
                mergedArray.add(temp2);
                n = n - 1;
                index2++;
            }
        }
        while(m > 0){
            mergedArray.add(nums1[index1]);
            index1++;
            m--;
        }
        
        while(n > 0){
            mergedArray.add(nums2[index2]);
            index2++;
            n--;
        }
        for(int i = 0; i < mergedArray.size(); i++){
            nums1[i] = mergedArray.get(i);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;

        MergeSortedArraySolution1 solution1 = new MergeSortedArraySolution1();
        solution1.merge(nums1,m,nums2,n);
    }
}
