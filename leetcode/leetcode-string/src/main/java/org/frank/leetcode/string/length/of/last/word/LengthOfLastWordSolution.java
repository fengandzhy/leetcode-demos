package org.frank.leetcode.string.length.of.last.word;

public class LengthOfLastWordSolution {
    
    public int lengthOfLastWord(String s) {
        String[] stringArray = s.split(" ");
        int length = stringArray.length;
        return stringArray[length -1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWordSolution length = new LengthOfLastWordSolution();
        System.out.println(length.lengthOfLastWord("luffy is still joyboy"));
    }
}
