package ds.sort.treeSeries;

/**
 * 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
 * 用递归做遍历，只要找到就返回
 * 不能递归函数内建立变量，其值混乱，要操作递归函数传过来的参数，其他子函数可以在其基础上累加
 * 不支持内部方法
 */
public class HasPathSum {
    public boolean hasPathSum (TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null && sum==0) return true;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
