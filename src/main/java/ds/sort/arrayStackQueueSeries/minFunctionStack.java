package ds.sort.arrayStackQueueSeries;

import java.util.Stack;

public class minFunctionStack {
    /*
    实现实时弹出最小元素的栈，在进栈时就维护好最小元素的状态
    排序要O(N),本题要求在O(1)复杂度，所以要借助辅助空间
     */
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    //push,维护最小元素状态
    public void push(int node){
        stack.push(node);

        if(stackMin.isEmpty()){
            stackMin.push(node);
        }else{
            if(stack.peek() < stackMin.peek()){
                stackMin.push(stack.peek());
            }else{
                stackMin.push(stackMin.peek());
            }
        }
    }

    //top
    public int top(){
        return stack.peek();
    }

    //pop
    public void pop(){
        stack.pop();
        stackMin.pop();
    }

    //min
    public int min(){
        return stackMin.peek();
    }
}
