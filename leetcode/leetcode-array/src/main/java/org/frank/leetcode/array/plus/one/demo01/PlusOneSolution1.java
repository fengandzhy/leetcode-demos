package org.frank.leetcode.array.plus.one.demo01;

import java.math.BigInteger;

public class PlusOneSolution1 {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for(int digit:digits){
            sb.append(digit);
        }
        BigInteger bigInteger = new BigInteger(sb.toString());
        bigInteger = bigInteger.add(BigInteger.ONE);
        String temp = bigInteger.toString();
        int[] result = new int[temp.length()];        
        for(int i = 0; i<result.length;i++){
            result[i] = Integer.parseInt(temp.substring(i,i+1));
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOneSolution1 solution1 = new PlusOneSolution1();
        solution1.plusOne(new int[]{1,2,3});
    }
}
