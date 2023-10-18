package org.frank.leetcode.string.length.of.last.word.demo01;

/**
 * https://leetcode.cn/problems/length-of-last-word/description/
 * */
public class LengthOfLastWordSolution1 {
    
    public int lengthOfLastWord(String s) {
        String[] stringArray = s.split(" ");
        int length = stringArray.length;
        return stringArray[length -1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWordSolution1 length = new LengthOfLastWordSolution1();
        System.out.println(length.lengthOfLastWord("luffy is still joyboy"));
    }
}
