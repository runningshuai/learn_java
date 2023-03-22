package ds.sort.treeSeries;

import java.util.LinkedList;


/**
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * 循环里：要么只判断true，要么只判断false，不要混着
 * 递归:结束条件可以混着判断，但要条件严谨，特征要调递归函数两次，要保证都成立
 */
public class Symmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot.left);
        queue.add(pRoot.right);

        //while 循环专职找false
        while(queue.size() > 0){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //扔到外面判断，不能直接发返回true,还有其他节点没有判断
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            queue.add(left.right);
            queue.add(right.left);
            queue.add(left.left);
            queue.add(right.right);
        }
        return true;
    }


    //递归
    boolean isSymmetrical2(TreeNode pRoot) {
        if(pRoot==null) return true;
        return isSymmetrical22(pRoot.left, pRoot.right);

    }

    boolean isSymmetrical22(TreeNode left, TreeNode right){

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        //有对有错的判断，要两个条件同时满足，因为其中一个都为空就可以返回true了
        return isSymmetrical22(left.left, right.right) && isSymmetrical22(left.right, right.left);

    }

}
