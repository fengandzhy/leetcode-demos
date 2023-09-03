package org.frank.leetcode.dynamic.programming.longest.palindrome.demo01;

public class LongestPalindromeSolution {

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/
     * */
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int factor = Math.max(longestPalindrome.length(), 1);
            for (int j = i + factor; j <= length; j++) {
                String tempStr = s.substring(i, j);
                if(isPalindrome(tempStr) && tempStr.length()>longestPalindrome.length()){
                    longestPalindrome  = tempStr;
                }
            }
        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String tempStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = tempStr.length() - 1; i >= 0; i--) {
            sb.append(tempStr.charAt(i));
        }
        return sb.toString().equals(tempStr);
    }

    public static void main(String[] args) {
        LongestPalindromeSolution solution = new LongestPalindromeSolution();
        String str = solution.longestPalindrome("a");
        System.out.println(str);
    }
}
