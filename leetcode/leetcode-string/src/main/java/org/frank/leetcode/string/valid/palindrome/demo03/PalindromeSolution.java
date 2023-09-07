package org.frank.leetcode.string.valid.palindrome.demo03;


public class PalindromeSolution {

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int beginIndex = 0;
        int endIndex = str.length() - 1;
        while (beginIndex < endIndex && beginIndex < str.length() && endIndex > 0) {
            char begin = str.charAt(beginIndex);
            while (isGoAhead(begin)) {
                beginIndex++;
                if (beginIndex < str.length()) {
                    begin = str.charAt(beginIndex);
                } else {
                    begin = ' ';
                    break;
                }
            }
            char end = str.charAt(endIndex);
            while (isGoAhead(end)) {
                endIndex--;
                if (endIndex > -1) {
                    end = str.charAt(endIndex);
                } else {
                    end = ' ';
                    break;
                }
            }
            if (Character.toLowerCase(begin) != Character.toLowerCase(end)) {
                return false;
            }
            beginIndex++;
            endIndex--;
        }
        return true;
    }

    private boolean isGoAhead(char c) {
        if (c >= 'A' && c <= 'Z') {
            return false;
        }
        if (c >= 'a' && c <= 'z') {
            return false;
        }
        return c < '0' || c > '9';
    }
}
