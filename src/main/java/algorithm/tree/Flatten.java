package algorithm.tree;

/**
 * @Description: 将二叉树展开为链表，展开后的链表和二叉树的前序遍历相同
 * @Author: bsy
 * @Date: 2022/11/29 18:58
 *
 */
public class Flatten {

    /**
     * 先拉平左子树，再拉平右子树，然后合在一起
     * @param root 根节点
     */
    void flatten(TreeNode root){
        if(root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = right;
    }

}
