package algorithm.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 全排列
 * @Author: bsy
 * @Date: 2023/1/5 1:35
 */
public class Permute {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> pathList = new LinkedList<>();
        int[] visited = new int[nums.length];
        traverse(nums, pathList, visited);
        return res;
    }

    void traverse(int[] nums, LinkedList<Integer> pathList, int[] visited){
        if(pathList.size()==nums.length){
            //需要new一个，不然后面的序列会改变之前的序列
            res.add(new LinkedList(pathList));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i]==1){
                continue;
            }
            pathList.add(nums[i]);
            visited[i] = 1;
            traverse(nums, pathList, visited);
            //撤销更改，供新的路径使用
            pathList.removeLast();
            visited[i] = 0;
        }
    }
}
