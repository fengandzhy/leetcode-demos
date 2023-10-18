package org.frank.leetcode.string.string.to.integer.atoi.demo01;

import java.math.BigInteger;

public class StringToIntegerAtoiSolution1 {
    public int myAtoi(String s) {
        StringBuilder number = new StringBuilder();
        s = s.trim();
        char[] chars = s.toCharArray();
        for(char c : chars){            
            if(c == '-' || c == '+'){
                if(number.length() == 0){
                    number.append(c);
                    continue;
                }else{
                    break;
                }                
            }            
            if(Character.isDigit(c)){
                number.append(c);
            }else {
                break;
            }            
        }
        if(number.length() == 0 || number.toString().equals("-") || number.toString().equals("+")){
            return 0;
        }
        BigInteger bigInteger = new BigInteger(number.toString());
        if(bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
            return Integer.MAX_VALUE;
        }
        if(bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0){
            return  Integer.MIN_VALUE;
        }
        return bigInteger.intValue();
    }

    public static void main(String[] args) {
        StringToIntegerAtoiSolution1 solution1 = new StringToIntegerAtoiSolution1();
        solution1.myAtoi("+-12");
    }
}
