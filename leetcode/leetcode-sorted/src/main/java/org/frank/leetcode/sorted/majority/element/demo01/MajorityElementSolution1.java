package org.frank.leetcode.sorted.majority.element.demo01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MajorityElementSolution1 {
    
    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                int value = map.get(n);
                map.put(n, value+1);
            }else{
                map.put(n,1);
            }
        }
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if(entry.getValue() > length/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("aa","bb");
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            if(iterator.next().getKey().equals("aa")){
                System.out.println("Find it.");
            }
        }
    }
}
