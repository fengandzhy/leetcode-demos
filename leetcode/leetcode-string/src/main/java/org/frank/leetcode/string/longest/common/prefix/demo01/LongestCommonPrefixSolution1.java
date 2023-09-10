package org.frank.leetcode.string.longest.common.prefix.demo01;

public class LongestCommonPrefixSolution1 {

    public String longestCommonPrefix(String[] strs) {
        String commonStr = "";
        int length = strs.length;
        int minLength = 0;
        for(int i = 0; i < length; i ++ ){
            if(minLength > strs[i].length() || i == 0){
                minLength = strs[i].length();
            }
        }
        while(minLength > 0){
            String initialStr = strs[0].substring(0, minLength);
            boolean ends = true;
            for(int i = 1; i<length;i++){
                String temStr = strs[i].substring(0, minLength);
                if(!temStr.equals(initialStr)){
                    ends = false;
                    minLength --;
                    break;
                }                
            }
            if(ends){
                commonStr = initialStr;
                break;
            }            
        }
        return commonStr;
    }
}
