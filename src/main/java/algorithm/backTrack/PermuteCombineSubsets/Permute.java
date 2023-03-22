package algorithm.backTrack.PermuteCombineSubsets;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 排列（元素无重不可复选）, 给定一个不含重复数字的数组 nums，返回其所有可能的全排列。
 * @Author: bsy
 * @Date: 2023/1/5 18:03
 */
public class Permute {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        traverse(nums, visited);
        return res;
    }

    void traverse(int[] nums, int[] visited){
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i]==1){
                continue;
            }
            track.add(nums[i]);
            visited[i] = 1;
            traverse(nums, visited);
            visited[i] = 0;
            track.removeLast();
        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permute per = new Permute();
        List<List<Integer>> permute = per.permute(nums);
        System.out.println(permute);
    }


}
