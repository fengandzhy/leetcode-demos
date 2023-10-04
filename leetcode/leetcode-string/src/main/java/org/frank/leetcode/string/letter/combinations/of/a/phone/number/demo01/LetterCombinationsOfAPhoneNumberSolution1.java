package org.frank.leetcode.string.letter.combinations.of.a.phone.number.demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumberSolution1 {
    public List<String> letterCombinations(String digits) {
        List<String> words = new ArrayList<>();
        char[] chars = digits.toCharArray();
        Map<Character, String[]> map = new HashMap<>();
        for(char c: chars){
            map.put(c, getLetters(c));
        }        
        return words;
    }
    
    public void combineStr(List<String> words, Map<Character, String[]> map, StringBuilder sb){
        
    }
    
    private String[] getLetters(char c){
        switch (c){
            case '2' : 
                return new String[]{"a", "b", "c"};
            case '3':
                return new String[]{"d", "e", "f"};
            case '4':
                return new String[]{"g", "h", "i"};
            case '5':
                return new String[]{"j", "k", "l"};
            case '6':
                return new String[]{"m", "n", "o"};
            case '7':
                return new String[]{"p", "q", "r","s"};
            case '8':
                return new String[]{"t", "u", "v"};
            case '9':
                return new String[]{"w", "x", "y","z"};
            default:
                return new String[]{};
        }
    }
}
