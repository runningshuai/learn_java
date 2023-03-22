package ds.sort.treeSeries;

import java.util.Stack;

public class PostOrder {
    public void postOrder(TreeNode tree){
        if(tree == null) return;

        Stack<TreeNode> result = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);

        while(!stack.empty()){
            TreeNode pop = stack.pop();
            if(pop.left != null) stack.push(pop.left);
            if(pop.right != null) stack.push(pop.right);
            result.push(pop);
        }

        while(!result.empty()){
            System.out.println(result.pop().val + "");
        }

    }
}
