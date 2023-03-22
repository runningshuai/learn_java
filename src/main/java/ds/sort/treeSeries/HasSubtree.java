package ds.sort.treeSeries;

import java.util.LinkedList;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
 * 思路：遍历大树，挨个去考察
 */
public class HasSubtree {

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2 == null)return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        while(queue.size() > 0){
            TreeNode pop = queue.pop();
            if(subtree(pop, root2)) return true;
            if(pop.left != null) queue.add(pop.left);
            if(pop.right != null) queue.add(pop.right);
        }
        return false;

    }

    public boolean subtree(TreeNode root1,TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val!=root2.val) return false;

        return subtree(root1.left,root2.left) && subtree(root1.right,root2.right);
    }

    //改变遍历大树的方式，换成递归
    public boolean hasSubtree2(TreeNode root1,TreeNode root2) {
        if(root1==null || root2 == null)return false;

        if(root1.val==root2.val){
            if(subtree(root1, root2)) return true;
        }

        return hasSubtree2(root1.left, root2) || hasSubtree2(root1.right, root2);

    }

}
