package algorithm.other.kuoHao;

import java.util.Stack;

/**
 * @Description: 是否有效括号, (),[],{}两两成对出现，且中间不能有其他括号[{]}是无效括号；
 * 思路：存储左边的括号，然后和右边的括号进行匹配
 * @Author: bsy
 * @Date: 2023/1/9 12:00
 */
public class IsValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur=='(' || cur=='[' || cur=='{'){
                stack.push(cur);
                //和最近的括号匹配
            }else if(!stack.isEmpty() && rightPair(cur)==stack.peek()){
                stack.pop();
                //和最近的括号不匹配
            }else{
                return false;
            }
        }

        return stack.isEmpty();

    }

    char rightPair(char c){
        if(c==')'){
            return '(';
        }else if(c==']'){
            return '[';
        }else{
            return '{';
        }
    }

    public static void main(String[] args) {
        String s = "]";
        IsValidParentheses isValidParentheses = new IsValidParentheses();
        boolean valid = isValidParentheses.isValid(s);
        System.out.println(valid);
    }
}
