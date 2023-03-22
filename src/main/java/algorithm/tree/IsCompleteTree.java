package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 是否完全二叉树
 * 完全二叉树的定义：若二叉树的深度为 h，除第 h 层外，
 * 其它各层的结点数都达到最大个数，第 h 层所有的叶子结点都连续集中在最左边，这就是完全二叉树。
 * （第 h 层可能包含 [1~2h] 个节点）
 * @Author: bsy
 * @Date: 2023/3/14 21:07
 */
public class IsCompleteTree {
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isLeaf = false;
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();

            // 第一次遇到叶子节点
            if(poll==null){
                isLeaf = true;
                continue;
            }

            // 后续迭代，若为true，说明之前遇到过叶子节点；包括左空右不空，上一层空下一层不空
            if(isLeaf){return false;}

            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return true;
    }
}
