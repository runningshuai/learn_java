package ds.sort.arrayStackQueueSeries;

import java.util.Stack;

/**
 * 不能边入队列，边出队列，会造成后入先出
 * stack1要一次性倒入stack2中
 */

public class stack2queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public stack2queue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void push(int node){
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new NullPointerException("stack is null");
        }
        return stack2.pop();
    }
}
