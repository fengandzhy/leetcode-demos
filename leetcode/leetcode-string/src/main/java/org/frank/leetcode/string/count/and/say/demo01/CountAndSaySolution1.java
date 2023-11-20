package org.frank.leetcode.string.count.and.say.demo01;

import java.util.HashMap;
import java.util.Map;

public class CountAndSaySolution1 {
    public String countAndSay(int n) {
        int count = 0;
        String str = "1";
        return calculate(n,count,str);
    }
    
    private String calculate(int n, int count, String str){
        if(n==count){
            return str;
        }
        String generatedStr = generateString(str);
        count++;        
        return calculate(n, count, generatedStr);
    }
    
    private String generateString(String str){
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<str.length()-2;i++){
            String temp = str.substring(i,i+1);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            sb.append(entry.getValue());
            sb.append(entry.getKey());
        }
        return sb.toString();
    }
}
