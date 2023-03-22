package algorithm.tree;

import java.util.LinkedList;

/**
 * @author 99195
 */
public class BuildTree {

    public TreeNode getDemoTree(){
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(8);

        tn1.left = tn2;
        tn1.right = tn3;

        tn2.left = tn4;
        tn2.right = tn5;
        tn3.right = tn6;

        tn5.left = tn7;
        tn5.right = tn8;

        return tn1;
    }

    public void levelTraverse(TreeNode head){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(head);

        while(!treeNodes.isEmpty()){
            // offer/add, remove/pull, element/peek
            TreeNode poll = treeNodes.poll();
            System.out.print(poll.val + " ");

            if(poll.left != null) {
                treeNodes.offer(poll.left);
            }
            if(poll.right != null) {
                treeNodes.offer(poll.right);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //比如我们常用的 LinkedList 集合，它实现了Queue 接口，因此，我们可以理解为 LinkedList 就是一个队列
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        BuildTree buildTree = new BuildTree();
        TreeNode cur = buildTree.getDemoTree();
        buildTree.levelTraverse(cur);

    }



}
