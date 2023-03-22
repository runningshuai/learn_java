package ds.sort.treeSeries;

import static java.lang.Math.max;

/**输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度，根节点的深度视为 1
 *
 */
public class treeDepth {

    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return max(left, right) + 1;
    }
}
