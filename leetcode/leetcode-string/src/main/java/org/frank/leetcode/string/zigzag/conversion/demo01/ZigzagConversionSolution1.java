package org.frank.leetcode.string.zigzag.conversion.demo01;

/**
 * https://leetcode.cn/problems/zigzag-conversion/
 * */
public class ZigzagConversionSolution1 {

    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        char[][] converter = new char[numRows][length];
        int row = 0;
        int column = 0;
        boolean downFlag = true;
        for (int i = 0; i < length; i++) {
            converter[row][column] = chars[i];
            if(numRows == 1){
                column = column + 1;
                continue;
            }
            if (downFlag) {
                row = row + 1;
                if (row == numRows - 1) {
                    downFlag = false;
                    continue;
                }
            }
            if (!downFlag) {
                row = row - 1;
                column = column + 1;
                if (row == 0) {
                    downFlag = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                if (Integer.valueOf(converter[i][j]) != 0) {
                    sb.append(converter[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversionSolution1 solution1 = new ZigzagConversionSolution1();
        solution1.convert("AB", 1);
    }


}
