package algorithm.tree;

/**
 * @Description: 是否二叉搜索树
 * 其中序遍历是升序，可考虑中序遍历，然后记录上一个元素，对当前值和上一个元素进行比较
 * @Author: bsy
 * @Date: 2023/3/15 20:34
 */
public class IsValidBST {
    int pre = Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        // write code here
        if(root == null){return true;}

        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val < pre){
            return false;
        }
        pre = root.val;

        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }

    /**
     * 如果一个二叉树是二插搜索树，那么一个非叶子节点的左子树所有节点的值一定都小于父节点的值，
     * 右子树所有节点的值一定都大于父节点的值。通过递归，我们可以不断缩小每个子树的取值范围
     * 对于左子树：需要小于当前父节点，大于负无穷
     * 对于右子树：需要大于当前父节点，小于父节点的父节点
     * @param root
     * @return
     */
    public boolean isValidBSTV2(TreeNode root){
        if(root == null){return true;}
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode root, int min, int max){
        if(root == null){return true;}

        if(root.val <= min || root.val >= max){
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
