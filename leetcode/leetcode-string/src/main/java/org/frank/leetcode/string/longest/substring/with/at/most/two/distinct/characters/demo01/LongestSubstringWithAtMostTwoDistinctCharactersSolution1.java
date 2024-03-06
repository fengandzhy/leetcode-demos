package org.frank.leetcode.string.longest.substring.with.at.most.two.distinct.characters.demo01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LongestSubstringWithAtMostTwoDistinctCharactersSolution1 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {        
        int length = s.length();
        int max = 0;
        int begin = 0;
        int end = 1;
        while(begin < length && end <= length){
            String sbStr = s.substring(begin, end);            
            if(isMoreThanTwoDistinctCharacters(sbStr)){
                begin ++;
                end = begin;
            }else{
                end ++ ;
                if(sbStr.length() > max){
                    max = sbStr.length();
                }
            }
        }
        return max;
    }
    
    private boolean isMoreThanTwoDistinctCharacters(String sbStr){
        if(sbStr.length() > 2){
            Set<Character> set = new HashSet<>();
            char[] chars = sbStr.toCharArray();
            for(char c:chars){
                set.add(c);
            }
            return set.size() > 2;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharactersSolution1 solution1 = new LongestSubstringWithAtMostTwoDistinctCharactersSolution1();
        solution1.lengthOfLongestSubstringTwoDistinct("ccaabbb");
        
    }
}
