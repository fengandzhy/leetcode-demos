package org.frank.leetcode.dynamic.programming.longest.palindrome.demo01;

public class LongestPalindromeSolution1 {

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/
     */
    public String longestPalindrome(String s) {        
        int subStringLength = s.length();
        int stringLength = s.length();
        while (subStringLength > 0) {
            int begin = 0;
            int end = subStringLength;
            while(end<=stringLength){
                String subString = s.substring(begin, end);
                if(isPalindrome(subString)){
                    return subString;
                }
                begin ++;
                end ++;
            }
            subStringLength--;
        }
        return "";
    }

    public boolean isPalindrome(String tempStr) {        
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

    public static void main(String[] args) {
        LongestPalindromeSolution1 solution = new LongestPalindromeSolution1();
        String str = solution.longestPalindrome("babad");
        System.out.println(str);
    }
}
