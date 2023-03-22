package ds.sort.arrayStackQueueSeries;

import java.util.Stack;

/**
 * 输入："nowcoder. a am I"
 * 返回值："I am a nowcoder."
 */
public class reverseSentence {
    static String reverseStringSentence(String str){
        Stack<String> stack = new Stack<>();
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();

        String[] strings = str.split(" ");
        for(int i=0; i<strings.length; i++){
//            if(strings[i].length()==1){
            stack.push(strings[i]);
//            }
        }

        while(stack.size()>0){
//            stringBuilder.append(stack.pop());
            result += stack.pop();
            if(stack.size()>1) result += " ";
        }
//        return stringBuilder.toString();

        return result;
    }

    public static void main(String[] args) {
        String s = reverseStringSentence("nowcoder. a am I");
        System.out.println(s);
    }
}

