package org.frank.leetcode.string.valid.palindrome.demo01;

public class PalindromeSolution {

    @SuppressWarnings("UnnecessaryLabelOnBreakStatement")
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        lableA:
        while (true) {            
            char cBegin = s.charAt(begin);
            char cEnd = s.charAt(end);
            if(isBreak(begin,end,s.length())) {
                break;
            }
            while (willGoHead(cBegin)) {
                begin++;
                if(isBreak(begin,end,s.length())) {
                    break lableA;
                }
                cBegin = s.charAt(begin);
            }
            while (willGoHead(cEnd)) {
                end--;
                if(isBreak(begin,end,s.length())) {
                    break lableA;
                }
                cEnd = s.charAt(end);
            }
            if (Character.toLowerCase(cBegin) == Character.toLowerCase(cEnd)) {
                if(isBreak(begin,end,s.length())){
                    break lableA;
                }else{
                    begin++;
                    end--;
                    if(isBreak(begin,end,s.length())){
                        break lableA;
                    }
                }                
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean isBreak(int begin, int end,int size){
        return begin == end || begin >= size || end <= 0;
    }

    private boolean willGoHead(char c) {
        if ((int) c >= 65 && (int) c <= 90) {
            return false;
        }
        if ((int) c >= 97 && (int) c <= 122) {
            return false;
        }
        return (int) c < 48 || (int) c > 57;
    }
}
