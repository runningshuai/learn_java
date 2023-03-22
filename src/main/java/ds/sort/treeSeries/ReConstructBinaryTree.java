package ds.sort.treeSeries;

import java.util.Arrays;

/**
 * 输入某二叉树的先序遍历和中序遍历的结果，请重建出该二叉树
 * 先序第一个节点是根节点，然后取中序遍历的结果去找，找到就连接上，找不到就不连接
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if(pre == null || pre.length==0 || in == null || in.length==0){
            return null;
        }

        //定义node串起来所有
        // 从上到下串起来，从下到上返回所有
        TreeNode node = null;
        for(int i=0; i<in.length; i++){
            if(pre[0]==in[i]){
                node = new TreeNode(pre[0]);
                // pre是跟左右，跟后面是一堆的左，然后是一对的右，其数量和中序的相等
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }

        return node;

    }

}
