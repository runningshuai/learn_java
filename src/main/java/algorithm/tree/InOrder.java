package algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:中序遍历
 * @Author: bsy
 * @Date: 2022/11/29 0:26
 */
public class InOrder {
    public void inorderTraverse(TreeNode root){
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode node = root;

        while(!treeNodes.isEmpty() || node != null){
            if(node != null){
                treeNodes.add(node);
                node = node.left;
            }else{
                TreeNode pop = treeNodes.pop();
                System.out.print(pop.val + ", ");
                node = pop.right;
            }
        }

    }

    public int[] inOrder(TreeNode root){
        if(root == null){return new int[0];}

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();

        while(root != null || !stack.isEmpty()){

            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode pop = stack.pop();
                res.add(pop.val);
                if(pop.right != null){
                    root = pop.right;
                }
            }
        }

        int[] result = new int[res.size()];
        for(int i=0; i< res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }

    public void inorderRecursion(TreeNode root){
        if(root == null) {
            return;
        }
        inorderRecursion(root.left);
        System.out.print(root.val + ", ");
        inorderRecursion(root.right);
    }

    public static void main(String[] args) {
        //创建二叉树
        BuildTree buildTree = new BuildTree();
        TreeNode demoTree = buildTree.getDemoTree();

        PreOrder preOrder = new PreOrder();

        preOrder.preOrderTraverse(demoTree);
        System.out.println("preOrderTraverse end!");

        InOrder inOrder = new InOrder();
        inOrder.inorderRecursion(demoTree);
        System.out.println("InOrderTraverse Recursion end!");

        inOrder.inorderTraverse(demoTree);
    }
}
