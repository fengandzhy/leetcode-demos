package org.frank.leetcode.array.plus.one.demo02;

public class PlusOneSolution2 {
    public int[] plusOne(int[] digits) {
        boolean isAllZero = false;
        int length = digits.length;
        for(int i = length -1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] = digits[i] + 1;
                break;
            }else{
                digits[i] = 0;
                if(i == 0){
                   isAllZero = true; 
                }
            }
        }
        if(isAllZero){
            int[] newArray = new int[length + 1];
            newArray[0] = 1;
            for(int i = 1;i < length + 1; i ++){
                newArray[i] = 0;
            }
            return newArray;
        }
        return digits;
    }
}
