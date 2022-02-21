package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//判断是否有效的括号
public class isValid {
    public boolean isValid(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        if(s.equals("")) return true;
        if (s.length()==1) return false;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i=1; i < s.length(); i++){
            if (map.containsKey(s.charAt(i)) && (stack.peek()==map.get(s.charAt(i)))){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid iv = new isValid();
        boolean result = iv.isValid("()[]{}");
        System.out.println(result);

    }
}
