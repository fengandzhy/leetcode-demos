package org.frank.leetcode.string.reverse.integer.demo02;

public class ReverseIntegerSolution2 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE /10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
            
        }
        return rev;
    }

    
}
