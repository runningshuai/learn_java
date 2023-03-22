package algorithm.divideAndConquer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 为运算表达式设计优先级
 * 输入：expression = "2-1-1", 输出：[0,2], 解释：((2-1)-1) = 0, (2-(1-1)) = 2
 * @Author: bsy
 * @Date: 2023/1/7 2:18
 */
public class DiffWaysToCompute {

    HashMap<String, List<Integer>> memo = new HashMap<>();

    /**
     * @param expression expression 由数字和算符 '+'、'-' 和 '*' 组成。
     * @return list
     */
    public List<Integer> diffWaysToCompute(String expression) {
        if(memo.containsKey(expression)){
            return memo.get(expression);
        }
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for(int m:left){
                    for(int n:right){
                        if(c=='+'){
                            res.add(m+n);
                        }else if(c=='-'){
                            res.add(m-n);
                        }else{
                            res.add(m*n);
                        }
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        memo.put(expression, res);
        return res;
    }

    public static void main(String[] args) {
        String s="2*3-4*5";
        DiffWaysToCompute diffWaysToCompute = new DiffWaysToCompute();
        List<Integer> integers = diffWaysToCompute.diffWaysToCompute(s);
        System.out.print(integers.toString());
    }

}
