package org.frank.leetcode.string.zigzag.conversion.demo01;

public class Count {
    public static void main(String[] args) {
       for(int i = 0; i< 10;i = i++){
           i+=1;
           System.out.println("aa");
       }
        
    }
    private static int count(){
        int n = 0;
        try{
            n++;
            return n;
        }finally{
            n++;
        }
    }
}
