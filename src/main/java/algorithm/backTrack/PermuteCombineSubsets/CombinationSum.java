package algorithm.backTrack.PermuteCombineSubsets;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 和为sum的子集，采用回溯法进行逐个求解; 组合题
 * 组合题，不能有顺序，所以之前用过的就不能再用了
 * @Author: bsy
 * @Date: 2023/1/6 0:17
 */
public class CombinationSum {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track =  new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        traverse(candidates, 0, target);
        return res;
    }

    void traverse(int[] candidates, int i, int target){
        if(sum==target){
            res.add(new LinkedList<>(track));
            return;
        }

        for(int start=i; start<candidates.length; start++){
            if(sum>target){
                continue;
            }

            track.add(candidates[start]);
            sum += candidates[start];
            traverse(candidates, start+1, target);
            track.removeLast();
            sum -= candidates[start];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(nums, 12);
        System.out.println(lists);
    }
}
