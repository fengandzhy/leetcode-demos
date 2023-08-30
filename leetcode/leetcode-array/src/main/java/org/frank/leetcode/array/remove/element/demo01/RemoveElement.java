package org.frank.leetcode.array.remove.element.demo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveElement {
    /**
     * https://leetcode.cn/problems/remove-element/solutions/
     * 
     * */
    public int removeElement(int[] nums, int val) {
        List<Integer> tempList = new ArrayList<>();
        for(int num:nums){
            tempList.add(num);
        }
        Iterator<Integer> iter = tempList.iterator();
        while(iter.hasNext()){
            if(val == iter.next()){
                iter.remove();
            }
        }        
        for(int i = 0;i<tempList.size();i++){
            nums[i] = tempList.get(i);
        }
        return tempList.size();
    }
}
