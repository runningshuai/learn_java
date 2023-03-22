package algorithm.tree;

/**
 * @Description: 镜像反转二叉树
 * @Author: bsy
 * @Date: 2022/11/29 17:32
 */
public class InvertTree {

    public TreeNode invertTreeTraverse(TreeNode root){
        reverse(root);
        return root;
    }
    void reverse(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        reverse(node.left);
        reverse(node.right);
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode demoTree = buildTree.getDemoTree();
        buildTree.levelTraverse(demoTree);

        InvertTree invertTree = new InvertTree();
        TreeNode invertTreeNode = invertTree.invertTreeTraverse(demoTree);
        buildTree.levelTraverse(invertTreeNode);
    }
}
