package org.frank.leetcode.array.three.sum.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {
    /**
     * https://leetcode.cn/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] tempArray = new int[3];
                        tempArray[0] = nums[i];
                        tempArray[1] = nums[j];
                        tempArray[2] = nums[k];
                        Arrays.sort(tempArray);
                        if(verify(tempArray,lists)){
                            lists.add(Arrays.stream(tempArray).boxed().collect(Collectors.toList()));
                        }
                    }
                }
            }
        }
        return lists;
    }

    public boolean verify(int[] tempArray, List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            if(list.get(0) == tempArray[0] && list.get(1) == tempArray[1]&& list.get(2) == tempArray[2]){
                return false;
            }
        }
        return true;
    }
}
