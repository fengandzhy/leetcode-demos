package org.frank.leetcode.string.length.of.last.word.demo02;

public class LengthOfLastWordSolution2 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        StringBuffer tempWord = new StringBuffer();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(c == ' '){
                tempWord = new StringBuffer();                
            }else{
                tempWord.append(c);
            }
        }
        return tempWord.length();
    }
}
