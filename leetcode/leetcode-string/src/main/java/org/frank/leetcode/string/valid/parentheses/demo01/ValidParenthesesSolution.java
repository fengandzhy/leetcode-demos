package org.frank.leetcode.string.valid.parentheses.demo01;

public class ValidParenthesesSolution {
    
    /**
     * https://leetcode.cn/problems/valid-parentheses/
     * 
     * */
    public boolean isValid(String s) {
        char[] chars = new char[s.length()];
        int top = -1;
        int length = s.length();
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            if(isLeft(c)){
                chars[top + 1] = c;
                top ++;
                continue;
            }
            if(isRight(c)){
                if(top > -1){
                    char left = chars[top];
                    top --;
                    if(!isMatch(left, c)){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return top == -1;
    }
    
    public boolean isLeft(char c){
        return c == '(' || c == '[' || c == '{';
    }

    public boolean isRight(char c){
        return c == ')' || c == ']' || c == '}';
    }
    
    public boolean isMatch(char left, char right){
        if(left == '('){
            return right == ')';
        }

        if(left == '['){
            return right == ']';
        }

        if(left == '{'){
            return right == '}';
        }       
        return false;
    }

    public static void main(String[] args) {
        ValidParenthesesSolution solution = new ValidParenthesesSolution();
        solution.isValid("]");
    }
}
