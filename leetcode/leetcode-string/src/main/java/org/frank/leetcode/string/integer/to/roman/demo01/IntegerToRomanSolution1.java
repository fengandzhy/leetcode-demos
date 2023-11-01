package org.frank.leetcode.string.integer.to.roman.demo01;

/**
 * https://leetcode.cn/problems/integer-to-roman/description/
 * */
public class IntegerToRomanSolution1 {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        transfer(num,sb);
        return sb.toString();
    }
    
    public void transfer(int num,StringBuilder sb ){
        if(num >= 1000){
            sb.append("M");
            num = num - 1000;
            transfer(num, sb);
        }else if(num >= 900){
            sb.append("CM");
            num = num % 100;
            transfer(num, sb);
        }else if(num >= 500){
            sb.append("D");
            num = num - 500;
            transfer(num, sb);
        }else if(num >=400){
            sb.append("CD");
            num = num % 100;
            transfer(num, sb);
        }else if(num >=100){
            sb.append("C");
            num = num - 100;
            transfer(num, sb);
        }else if(num >= 90){
            sb.append("XC");
            num = num % 10;
            transfer(num, sb);
        }else if(num >= 50){
            sb.append("L");
            num = num - 50;
            transfer(num, sb);
        }else if(num >= 40){
            sb.append("XL");
            num = num % 10;
            transfer(num,sb);
        }else if(num >=10){
            sb.append("X");
            num = num -10;
            transfer(num,sb);
        }else if(num == 9){
            sb.append("IX");
        }else if(num >= 5){
            sb.append("V");
            num = num - 5;
            transfer(num, sb);
        }else if(num == 4){
            sb.append("IV");
        }else if(num <=3 && num >0){
            sb.append("I");
            num = num - 1;
            transfer(num,sb);
        }
    }

    public char mappingNumber(int number) {
        switch (number) {
            case 1:
                return 'I';
            case 5:
                return 'V';
            case 10:
                return 'X';
            case 50:
                return 'L';
            case 100:
                return 'C';
            case 500:
                return 'D';
            case 1000:
                return 'M';
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        IntegerToRomanSolution1 solution1 = new IntegerToRomanSolution1();
        solution1.intToRoman(5009);
    }
}
