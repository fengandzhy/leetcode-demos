package org.zhouhy.leetcode.string.valid.palindrome.demo02;

public class PalindromeSolution {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if((int) c >= 65 && (int) c <= 90){                
                sb.append((char)(c+32));                
            }
            if((int) c >= 48 && (int) c <= 57){
               sb.append(c);                
            }
            if ((int) c >= 97 && (int) c <= 122) {
                sb.append(c);                
            }
        }
        String str = sb.toString();        
        int length = str.length();
        for(int i=0;i<length;i++){
            if(i==length-1-i){
                break;
            }
            if(str.charAt(i) != str.charAt(length-1-i)){
                return false;
            }            
        }        
        return true;
    }
}
