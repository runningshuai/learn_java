package ds.sort.treeSeries;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 不分行从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 层次遍历
 * 不用任何辅助数据结构，会沿着一条子树分裂，实现不了层次遍历
 */
public class printFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if(root == null) return new ArrayList<>();
        LinkedList<TreeNode> linkes = new LinkedList<>();
        linkes.add(root);
        ArrayList<Integer> result = new ArrayList<>();


        while(linkes.size()>0){
            //树节点必须出队列，不然获取不到左右子节点
            TreeNode head = linkes.poll();
            result.add(head.val);

            if(head.left != null) linkes.add(head.left);
            if(head.right != null) linkes.add(head.right);
        }
        return result;



    }
}
