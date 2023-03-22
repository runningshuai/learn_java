package algorithm.backTrack;

import java.util.LinkedList;
import java.util.List;


/**
 * @Description: 产生配对的括号，请你写一个算法，输入是一个正整数 n，输出是 n 对儿括号的所有合法组合
 * @Author: bsy
 * @Date: 2023/1/6 0:52
 */
public class GenerateParenthesis {

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        traverse(n,n);
        return res;

    }

    void traverse(int left, int right){
        if(left <0 || right<0){
            return;
        }
        //剩余的左右括号
        if(left > right){
            return;
        }

        if(left==0&&right==0){
            res.add(sb.toString());
        }
        //两个选择
        sb.append('(');
        traverse(left -1, right);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        traverse(left, right - 1);
        sb.deleteCharAt(sb.length() - 1);

    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        System.out.println(strings);
    }
}
