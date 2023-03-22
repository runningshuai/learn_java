package ds.sort.treeSeries;

import java.util.Stack;

/**
 * 参考
 * https://blog.csdn.net/abcdef314159/article/details/107130830/
 */
public class InOrder {
    public void inOrderRecurRecursion(TreeNode tree){
        if(tree == null) return;
        inOrderRecurRecursion(tree.left);
        System.out.println(tree.val + "");
        inOrderRecurRecursion(tree.right);
    }

    public void inOrder(TreeNode tree){
        if(tree == null) return;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.empty() || tree != null){
            //先左子树进栈，然后右子树进栈
            if(tree != null){
                stack.push(tree);
                tree = tree.left;
            }else{
                tree = stack.pop();
                System.out.print(tree.val + "");
                tree = tree.right;
            }
        }
    }

}
