package algorithm.tree;

/**
 * @Description: 是否对称二叉树
 * 思路，需要传入两个节点的作为参数；若是需要判断连续两层的树节点，则可以考虑扩展参数的方法
 * @Author: bsy
 * @Date: 2023/3/14 17:19
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){return true;}

        return isEqual(pRoot.left, pRoot.right);
    }

    boolean isEqual(TreeNode left, TreeNode right){
        // 两者都为空
        if(left == null && right == null){return true;}
        // 其中一个为空
        if(left == null || right == null){return false;}
        // 都不为空
        if(left.val != right.val){return false;}

        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }
}
