package ds.sort.arrayStackQueueSeries;

import java.util.Stack;

public class stackPushAndPop {
    /*
   模拟法，扫描入栈数组，然后数据对比
   相等，弹出元素，不相等入栈
   判断栈是否为空
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0; i< pushA.length; i++){
            stack.push(pushA[i]);
            //不确定长度，用while循环
            while(!stack.isEmpty()&&stack.peek()==popA[j]){
                stack.pop();
                j += 1;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean b = IsPopOrder(new int[]{1,2,3,4,5}, new int[]{3, 4,5,2,1});
        System.out.println(b);
    }
}
