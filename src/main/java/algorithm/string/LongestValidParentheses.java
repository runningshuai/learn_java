package algorithm.string;

import java.util.Stack;

/**
 * @Description: 最长的括号子串, 栈不直接存元素，存索引
 * @Author: bsy
 * @Date: 2023/2/19 16:27
 */
public class LongestValidParentheses {

    public int longestValidParenthesesDp (String s){
        if(s.length()<=1){return 0;}
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)=='('){
                dp[i] = 0;
            }else{
                if(s.charAt(i-1) == '('){
                    dp[i] = (i-2>=0?dp[i-2]:0) + 2;
                }
                if(s.charAt(i-1) == ')' && i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1)=='('){
                    dp[i] = (i - dp[i-1] - 2>=0 ? dp[i - dp[i-1] - 2]:0) +  dp[i-1] + 2;
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int longestValidParentheses (String s) {
        // write code here
        if(s.length()<=1){return 0;}
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int count = 0;
        // 增加起始左侧索引，后面右侧索引减去次左侧索引，即是长度
        stack.push(-1);
        for(int i=0; i<s.length(); i++){
            // 遇到做左括号进栈，刚开始前置索引是-1
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                // 刚开始就遇到右括号，还没进栈，就出栈，导致栈为空。此时右括号也进栈，用作左括号的前置索引
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    // 左括号匹配
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        int res = solution.longestValidParentheses("(()()");
        System.out.println(res);


        int res2 = solution.longestValidParenthesesDp("(((((((()))))))");
        System.out.println(res2);
    }
}
