package org.frank.leetcode.dynamic.programming.longest.palindrome.demo02;

public class LongestPalindromeSolution2 {
    
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

    @SuppressWarnings("DuplicatedCode")
    private boolean isPalindrome(String tempStr) {
        int begin = 0;
        int end = tempStr.length() -1;
        while(end > begin){
            if(tempStr.charAt(end) != tempStr.charAt(begin)){
                return false;
            }
            begin ++;
            end --;
        }
        return true;
    }
}
