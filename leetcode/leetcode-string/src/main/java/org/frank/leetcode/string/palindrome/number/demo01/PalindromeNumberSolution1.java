package org.frank.leetcode.string.palindrome.number.demo01;

/**
 * https://leetcode.cn/problems/palindrome-number/description/
 * */
public class PalindromeNumberSolution1 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = chars.length - 1;i >= 0;i--){
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString().equals(str);
    }
}
