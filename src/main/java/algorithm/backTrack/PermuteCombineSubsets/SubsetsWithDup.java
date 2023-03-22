package algorithm.backTrack.PermuteCombineSubsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * @Author: bsy
 * @Date: 2023/1/5 20:31
 */
public class SubsetsWithDup {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));


        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝(不是上下树枝)，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> lists = subsetsWithDup.subsetsWithDup(nums);
        System.out.println(lists.size());
        System.out.println(lists);
    }

}
