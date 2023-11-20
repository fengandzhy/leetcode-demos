package org.frank.leetcode.string.count.and.say.demo01;



public class CountAndSaySolution1 {
    public String countAndSay(int n) {
        int count = 1;
        String str = "1";
        return calculate(n,count,str);
    }
    
    private String calculate(int n, int count, String str){
        if(n==count){
            return str;
        }
        String generatedStr = generateString(str);
        count++;        
        return calculate(n, count, generatedStr);
    }
    
    private String generateString(String str){
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int count = 1;
        int left = 0;
        int right = 1;
        while(true){
            if(right > str.length() - 1){
                sb.append(count);
                sb.append(chars[left]);
                break;
            }
            if(chars[left]==(chars[right])){
                count ++;
            }else{
                sb.append(count);
                sb.append(chars[left]);
                count = 1;
            }
            left = left + 1;
            right = right + 1;
        }        
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSaySolution1 solution1 = new CountAndSaySolution1();
        solution1.countAndSay(4);
    }
}
