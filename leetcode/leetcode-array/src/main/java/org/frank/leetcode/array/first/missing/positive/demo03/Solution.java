package org.frank.leetcode.array.first.missing.positive.demo03;

public class Solution {
    public String solution(String S) {
        char[] chars = S.toCharArray();
        int n = chars.length;

        if (chars[0] == '1' && Integer.parseInt(S) == Math.pow(10, n - 1)) {
            // Handle special case for numbers like 10, 100, 1000, ...
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                result.append('9');
            }
            return result.toString();
        }

        // Start from the first digit and look for the first place where we can decrease the digit
        for (int i = 0; i < n; i++) {
            if (chars[i] > '0') {
                // Decrease this digit by one
                chars[i]--;

                // Set all following digits to '9' to maximize the sum
                for (int j = i + 1; j < n; j++) {
                    chars[j] = '9';
                }
                break;
            }
        }

        return new String(chars).replaceAll("^0+(?!$)", ""); // Replace leading zeros if any        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("19");
    }
    
}
