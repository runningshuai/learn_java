package algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/** 前序遍历
 * https://blog.csdn.net/weixin_47382783/article/details/123821339
 * https://www.cnblogs.com/zhi-leaf/p/10813048.html
 * @author 99195
 */
public class PreOrder {

    public void preOrderTraverse(TreeNode head){
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(head);

        while(!treeNodes.isEmpty()){
            TreeNode peek = treeNodes.pop();
            System.out.print(peek.val + ", ");
            if(peek.right != null) {
                treeNodes.push(peek.right);
            }
            if(peek.left != null) {
                treeNodes.push(peek.left);
            }
        }
        System.out.println();
    }

    public void preOrderTraverseV2(TreeNode head){
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode node = head;

        while(!treeNodes.isEmpty() || node != null){
            if(node != null){
                System.out.print(node.val + " ");
                treeNodes.add(node);
                node = node.left;
           }else{
                TreeNode pop = treeNodes.pop();
                node = pop.right;
            }
        }
        System.out.println();
    }

    //
    public int[] preOrderTraverseV3(TreeNode root){
        if(root == null){return new int[0];}
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                res.add(root.val);
                stack.add(root);
                root = root.left;

            }else {
                TreeNode node = stack.pop();
                if(node.right != null){
                    root = node.right;
                }
            }
        }
        int[] arr = new int[res.size()];
        for(int i=0; i< res.size(); i++){
            arr[i] = res.get(i);
        }

        return arr;
    }

    public void preOrderRecursion(TreeNode head){
        if(head == null) {
            return;
        }
        System.out.print(head.val + ", ");
        preOrderRecursion(head.left);
        preOrderRecursion(head.right);
    }


    public static void main(String[] args) {
        //创建二叉树
        BuildTree buildTree = new BuildTree();
        TreeNode demoTree = buildTree.getDemoTree();

        PreOrder preOrder = new PreOrder();

        preOrder.preOrderTraverse(demoTree);
        System.out.println("preOrderTraverse end!");

        preOrder.preOrderRecursion(demoTree);
        System.out.println("preOrderRecursion end!");

        preOrder.preOrderTraverseV2(demoTree);
        System.out.println("preOrderTraverseV2 end!");

    }
}
