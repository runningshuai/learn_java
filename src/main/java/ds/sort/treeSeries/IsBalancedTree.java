package ds.sort.treeSeries;

public class IsBalancedTree {

    public Boolean isBalancedTree(TreeNode tree){
        //从上到下递归，存在重复计算，复杂度高O(n^2)
//        if(tree == null) return true;
        //找茬，只要有一个就不满足。满足的在最后，所以刚开始要找不满足的情况，只有这一个
//        if(Math.abs(treeDepth(tree.left) - treeDepth(tree.right)) > 1) return false;
        //若满足，则继续往下查找
//        return isBalancedTree(tree.left) && isBalancedTree(tree.left);

        //时间复杂度O(N)
        return treeDepth2(tree) >=0;

    }

    public int treeDepth(TreeNode tree){
        if(tree == null) return 0;
        int left = treeDepth(tree.left);
        int right = treeDepth(tree.right);
        //左右子树的高度的最大值(从最底层开始累加) + 当前节点的高度1
        return left > right ? left + 1: right + 1;
    }

    public int treeDepth2(TreeNode tree){
        //时间复杂度o(N)
        if(tree == null) return 0;
        int left = treeDepth(tree.left);
        int right = treeDepth(tree.right);
        //不是平衡二叉树标记为-1, 向上归的时候有-1存在，此时直接返回-1,传到最上层，最后返回函数
        if(left==-1 || right==-1 || Math.abs(left - right) > 1){
            return -1;
        }else {
            //是平衡二叉树返回高度
            return left > right ? left + 1 : right + 1;
        }
    }


}
