package algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Description: z字型打印二叉树
 * @Author: bsy
 * @Date: 2023/3/13 23:11
 */
public class ZPrint {

    public ArrayList<ArrayList<Integer>> zPrint(TreeNode pRoot) {
        if(pRoot==null){return new ArrayList<>();}

        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int line = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i=0; i< size; i++){
                TreeNode poll = queue.poll();
                level.add(poll.val);

                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            line += 1;
            if(line % 2 ==1){
                result.add(new ArrayList<>(level));
            }else{
                Collections.reverse(level);
                result.add(new ArrayList<>(level));
            }
        }
        return result;
    }
}
