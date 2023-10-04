package org.frank.leetcode.string.letter.combinations.of.a.phone.number.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/ 
 * */
public class LetterCombinationsOfAPhoneNumberSolution1 {
    public List<String> letterCombinations(String digits) {
        List<String> words = new ArrayList<>();
        if (digits.length() == 0) {
            return words;
        }
        char[] chars = digits.toCharArray();
        List<String[]> lists = new ArrayList<>();
        for(char c: chars){
            lists.add(getLetters(c));
        }
        int index = 0;
        String[] strings = lists.get(index);
        for(String string:strings){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            combineStr(stringBuilder,lists,index+1,words);
        }
        return words;
    }
    
    public void combineStr(StringBuilder stringBuilder, List<String[]> lists, int index, List<String> words){
        if(index == lists.size()){
            words.add(stringBuilder.toString());
            return;
        }
        String[] strings = lists.get(index);
        for(String string:strings){
            stringBuilder.append(string);
            combineStr(stringBuilder,lists,index+1,words);
            stringBuilder.deleteCharAt(index);
        }
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

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumberSolution1 solution1 = new LetterCombinationsOfAPhoneNumberSolution1();
        solution1.letterCombinations("23");
    }
}
