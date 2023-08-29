package org.frank.leetcode.array.remove.element.demo02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i] != val){
               nums[length] = nums[i];
               length ++;
           }
        }
        return length;
    }
}
