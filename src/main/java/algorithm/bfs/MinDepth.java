package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 二叉树最小高度, 使用BFS,广度优先遍历，使用队列逐个数据结构
 * @Author: bsy
 * @Date: 2023/1/6 1:25
 */
public class MinDepth {
    int minDepth(TreeNode root) {
        if(root==null){return 0;}
        Queue<TreeNode> q = new LinkedList<>();
        //起点
        q.offer(root);
        int depth=1;

        while(!q.isEmpty()){
            int size = q.size();
            //遍历q中的所有节点，即遍历一层
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                //终点
                if(node.left==null && node.right==null){
                    return depth;
                }

                //下一层
                if(node.left !=null){
                    q.offer(node.left);
                }
                if(node.right !=null){
                    q.offer(node.right);
                }
            }
            depth +=1;
        }
        return depth;
    }

}
