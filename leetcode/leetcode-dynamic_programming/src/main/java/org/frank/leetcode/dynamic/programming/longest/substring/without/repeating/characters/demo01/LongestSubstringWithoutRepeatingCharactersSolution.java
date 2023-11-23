package org.frank.leetcode.dynamic.programming.longest.substring.without.repeating.characters.demo01;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersSolution {

    
    /**
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/ 
     * 以下解法应该正确, 但是超出时间限制
     * */
//    public int lengthOfLongestSubstring(String s) {        
//        int subStringLength = s.length();
//        int stringLength = s.length();
//        while (subStringLength > 0) {
//            int begin = 0;
//            int end = subStringLength;
//            while (end <= stringLength) {
//                String subString = s.substring(begin, end);
//                if(!hasRepeatable(subString)){
//                    return subString.length();
//                }
//                begin ++;
//                end ++;
//            }
//            subStringLength--;
//        }
//        return 0;
//    }
//
//    public boolean hasRepeatable(String s) {
//        int begin = 0;
//        int end = 1;
//        while (end <= s.length()) {
//            String subStr1 = s.substring(0,begin);
//            String subStr2 = s.substring(end,s.length());
//            String factor = s.substring(begin,end);
//            if(subStr1.indexOf(factor) != -1 || subStr2.indexOf(factor) != -1){
//                return true;
//            }
//            begin++;
//            end++;
//        }
//       return false; 
//    }

//    public static void main(String[] args) {
//        LongestSubstringWithoutRepeatingCharactersSolution s = new LongestSubstringWithoutRepeatingCharactersSolution();
//        s.lengthOfLongestSubstring("abcabcbb");
//    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j<len;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j),j);
            res = Math.max(res, j-i);
        }
        return res;
    }
}
