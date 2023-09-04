package org.frank.leetcode.dynamic.programming.longest.substring.without.repeating.characters.demo02;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersSolution {
    
    /**
     * 
     * */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j<len;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j))); // 确保左边的指针始终在正确的位置上, 例如 abcba 这个字符串, 第一次i 停在b这里,第二次,还是希望停在b这里
            }
            map.put(s.charAt(j),j);
            res = Math.max(res, j-i);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersSolution s = new LongestSubstringWithoutRepeatingCharactersSolution();
        s.lengthOfLongestSubstring("pwwkew");
    }
}
