package org.frank.leetcode.string.roman.to.integer.demo01;

public class RomanToIntegerSolution {

    /**
     * https://leetcode.cn/problems/roman-to-integer
     * 通常情况下，罗马数字中小的数字在大的数字的右边。若输入的字符串满足该情况，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可。
     *
     * 例如 XXVII\texttt{XXVII}XXVII 可视作 X+X+V+I+I=10+10+5+1+1=27\texttt{X}+\texttt{X}+\texttt{V}+\texttt{I}+\texttt{I}=10+10+5+1+1=27X+X+V+I+I=10+10+5+1+1=27。
     *
     * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
     *
     * 例如 XIV\texttt{XIV}XIV 可视作 X−I+V=10−1+5=14\texttt{X}-\texttt{I}+\texttt{V}=10-1+5=14X−I+V=10−1+5=14。
     * 
     *     
     * */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] numbers = new int[length];
        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = transferNumber(chars[i]);
        }
        int before = 1;
        int end = 0;
        while (before < length) {
            if (numbers[before] > numbers[end]) {
                numbers[end] = 0 - numbers[end];
            }
            before++;
            end++;
        }
        for (int i = 0; i < length; i++) {
            value = value + numbers[i];
        }
        return value;
    }

    public int transferNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        RomanToIntegerSolution solution = new RomanToIntegerSolution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
