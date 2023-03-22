package algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 后序遍历
 * @Author: bsy
 * @Date: 2022/11/29 1:06
 */
public class PostOrder {

    public void postOrderRecursion(TreeNode root){
        if(root == null){
            return;
        }
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.val + ", ");

    }

    /**
     * ① 有左入栈左
     * ②无左，访问栈顶，有右子树且未被访问过，则入栈(当前指针移动到这里即可)
     * ③以上都不满足else, 出栈，访问栈顶元素
     * @param root
     */
    public void postOrderTraverse(TreeNode root){
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisited = null;

        while(cur != null || !treeNodes.isEmpty()){
            //有左入左
            if(cur != null){
                treeNodes.push(cur);
                cur = cur.left;
            // 无左
            }else{
                TreeNode peek = treeNodes.peek();
                // 有右子树且未被访问
                if((peek.right != null)&&(peek.right != lastVisited)){
                    cur = peek.right;
                //无左子树、无右子树
                }else{
                    TreeNode pop = treeNodes.pop();
                    System.out.print(pop.val + ", ");
                    lastVisited = pop;
//                    cur = null;
                }
            }
        }
    }

    public int[] postOrderTraverseV3(TreeNode root){
        if(root == null){return new int[0];}

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                res.add(root.val);
                root = root.right;
            }else{
                TreeNode pop = stack.pop();
                if(pop.left != null){
                    root = pop.left;
                }
            }
        }


        int length = res.size();
        int[] result = new int[length];

        for(int i=0; i<res.size(); i++){
            result[0] = res.get(length - 1 - i);
        }
        return result;
    }

    public static void main(String[] args) {
        //创建二叉树
        BuildTree buildTree = new BuildTree();
        TreeNode demoTree = buildTree.getDemoTree();

        PreOrder preOrder = new PreOrder();
        preOrder.preOrderTraverse(demoTree);
        System.out.println("preOrderTraverse end!");

        InOrder inOrder = new InOrder();
        inOrder.inorderRecursion(demoTree);
        System.out.println("InOrderTraverse end!");

        PostOrder postOrder = new PostOrder();
        postOrder.postOrderRecursion(demoTree);
        System.out.println("postOrderRecursion end");
        postOrder.postOrderTraverse(demoTree);

    }

}
