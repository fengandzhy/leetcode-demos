package org.frank.leetcode.string.generate.parentheses.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/
 * */
public class GenerateParenthesesSolutions1 {

    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        getBracket("", n, n, list);
        return list;
    }
    
    public void getBracket(String str, int left, int right, List<String> list){
        // 如果 ( 和 ) 的剩余数量都是0, 那么就是一个可以被list 吸收的字符串
        if(left == 0 && right == 0){
            list.add(str);
            return;
        }
        
        if(left == right){
            getBracket(str+"(", left-1, right, list);
        }
        
        /**
         * 当( 剩余 小于 ) 时, 下一个既可以是 ( 也可以是 ) 但是 如果要是 ( 的话 left > 0  
         * 
         * */
        if(left < right){
            if(left > 0){
                getBracket(str+"(", left-1, right, list); // 当 left < right 的时候, 可以继续是 左边括号 (
            }
            getBracket(str+")", left, right-1, list); // 当 left > right 的时候, 可以继续是 右边括号 ) 
        }        
    }

    public static void main(String[] args) {
        
    }
    
}
