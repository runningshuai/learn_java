package algorithm.tree.constructTree;

import algorithm.tree.TreeNode;

/**
 * @Description: 由数组构造最大二叉树
 * 二叉树的构造问题一般都是使用「分解问题」的思路：构造整棵树 = 根节点 + 构造左子树 + 构造右子树。
 * @Author: bsy
 * @Date: 2022/11/29 23:17
 * 先找最大值，然后左右两个子树，依次递归进行
 */
public class ConstructMaximumBinaryTree {
    TreeNode constructMaximumBinaryTree(int[] nums){
        return build(nums, 0, nums.length -1);

    }

    TreeNode build(int[] nums, int i, int j){
        //bad case
        if(i > j){
            return null;
        }

        int index = -1, maxVal = Integer.MIN_VALUE;
        for(int k=i; k<j; k++){
            if(nums[k] > maxVal){
                maxVal = nums[k];
                index = k;
            }
        }

        TreeNode left = build(nums, i, index - 1);
        TreeNode right = build(nums, index + 1, j);

        TreeNode cur = new TreeNode(maxVal);
        cur.left = left;
        cur.right = right;
        return cur;
    }
}
