package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 17电话号码组合，digits一个数字代表一层
 * 树路径上字母串在一起就是组合
 * @Author: bsy
 * @Date: 2023/2/28 20:51
 */
public class LetterCombinations {

    String[] letter = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if(digits.length() <= 0){return res;}
        traverse(digits, 0);
        return res;
    }

    public void traverse(String digits, int start){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(start);
        // 从数字2开始
        String s = letter[c - '2'];
        // 下一层做选择
        for(char ch :s.toCharArray()){
            sb.append(ch);
            // 下一层
            traverse(digits, start +1);
            // 递归回来，去掉上次增加的，探索下一个选择
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();
        List<String> res = solution.letterCombinations("23");
        System.out.println(res);


    }
}
