package ds.sort.treeSeries;

import java.util.Stack;

/**
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。
 * 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
 * 3.保证n个节点的值不一样
 * 注意k≥0
 */
public class KthNode {
    //返回地K小的值，也就是反序topK. 中序遍历，当个数达到就返回
    public int KthNode (TreeNode proot, int k) {
        if(proot==null || k<=0 ) return -1;
        // 需要中间判断，n<k的情况

        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while(!stack.isEmpty() || proot !=null){
            if(proot !=null){
                stack.push(proot);
                proot = proot.left;
            }else {
                proot = stack.pop();
                i += 1;
                if(i==k) {
                    return proot.val;
                }
                proot = proot.right;
            }
        }
        return -1;

    }
}
