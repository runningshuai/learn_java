package algorithm.tree;

/**
 * @Description: 是否平衡二叉树
 * @Author: bsy
 * @Date: 2023/3/14 20:16
 */
public class IsBalancedTree {

    boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){return true;}
        treeHigh(root);
        return isBalance;

    }

    public int treeHigh(TreeNode root){
        if(root==null){return 0;}

        int left = treeHigh(root.left);
        if(left == -1){return -1;}
        int right = treeHigh(root.right);
        if(right == -1){return -1;}
        if(Math.abs(left - right) > 1){
            // 提前返回进行剪枝
            isBalance = false;
            return -1;
        }

        return Math.max(treeHigh(root.left), treeHigh(root.right)) +  1;

    }
}
