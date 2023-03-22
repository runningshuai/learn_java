package algorithm.backTrack;

import java.util.LinkedList;
import java.util.List;

/** 子集（元素无重复不可重复选）
 * @Description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 排列组合的子集
 * @Author: bsy
 * @Date: 2023/1/5 17:09
 */
public class Subsets {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        traverse(nums, 0);
        return res;

    }

    void traverse(int[] nums, int i){
        //没有显示的终止递归条件，通过i值来控制递归的终止
        res.add(new LinkedList<>(track));

        for(int start=i; start<nums.length; start++){
            track.addLast(nums[start]);
            traverse(nums, start+1);
            track.removeLast();
        }
    }
}
