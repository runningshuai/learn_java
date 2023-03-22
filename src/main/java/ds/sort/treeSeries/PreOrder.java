package ds.sort.treeSeries;

import java.util.Stack;

public class PreOrder {
    public  static void preOrdeRecursion(TreeNode tree){
        if(tree == null) return;
        System.out.print(tree.val + "");

        //这个先执行，一直执行到叶子节点，然后归
        preOrdeRecursion(tree.left);
        //跟着归
        preOrdeRecursion(tree.right);
    }
    public  static void preOrde(TreeNode tree){
        if(tree == null) return;
        //采用栈，右边先进站

        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            System.out.print(pop.val + "");

            if(pop.right != null){
                stack.push(pop.right);
            }

            if(pop.left != null){
                stack.push(pop.left);
            }
        }

    }

}
