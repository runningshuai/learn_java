package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description: 树的层次遍历，使用队列，取size个节点
 * @Author: bsy
 * @Date: 2023/3/13 22:20
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        if(root==null){
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode poll = queue.poll();
                level.add(poll.val);

                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            result.add(new ArrayList<>(level));
        }

        return result;

    }
}
