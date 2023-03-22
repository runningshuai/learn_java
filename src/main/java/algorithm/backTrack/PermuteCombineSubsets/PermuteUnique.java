package algorithm.backTrack.PermuteCombineSubsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 排列（元素可重不可复选）
 * @Author: bsy
 * @Date: 2023/1/5 20:11
 */
public class PermuteUnique {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置,!used[i-1]，能保证上下一致不会进入循环，同时从上到下剪枝相邻子树
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            System.out.println(track);
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2};
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> lists = permuteUnique.permuteUnique(nums);
        System.out.println(lists.size());
        System.out.println(lists);
    }

}
