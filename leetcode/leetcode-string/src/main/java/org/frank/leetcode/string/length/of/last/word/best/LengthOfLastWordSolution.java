package org.frank.leetcode.string.length.of.last.word.best;

public class LengthOfLastWordSolution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                break;
            }
            count ++;
        }
        return count ++;
    }
}
