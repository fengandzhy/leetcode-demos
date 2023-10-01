package org.frank.leetcode.string.reverse.integer.demo01;

import java.math.BigInteger;

/**
 * https://leetcode.cn/problems/reverse-integer/description/
 * */
public class ReverseIntegerSolution1 {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        int reverseInt = 0;
        String tempStr = String.valueOf(x);
        boolean isCount = false;
        String operator = "";
        StringBuilder stringBuilder = new StringBuilder();
        if(tempStr.substring(0,1).equals("-")){
            operator = "-";
            tempStr = tempStr.substring(1);
        }
        char[] chars = tempStr.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]  != '0'){
                isCount = true;
            }
            if(isCount){
                stringBuilder.append(chars[i]);
            }
        }
        BigInteger bigInteger = new BigInteger(operator+stringBuilder.reverse().toString());
        if(bigInteger.compareTo(new BigInteger(String.valueOf(0l - (long)Math.pow(2,31)))) > 0 && 
        bigInteger.compareTo(new BigInteger(String.valueOf((long)Math.pow(2,31) -1l))) < 0){
            reverseInt = bigInteger.intValue();
        }
        return reverseInt;
    }

    public static void main(String[] args) {
        String.valueOf(0l - (long)Math.pow(2,31));
        System.out.println(String.valueOf(0l - (long)Math.pow(2,31)));
    }
}
