package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) {
        int[] result = twoSum1(new int[] {1, 2, 3}, 4);
        System.out.println("twoSum1 " + Arrays.toString(result));
        int[] result2 = twoSum2(new int[] {1, 2, 5}, 3);
        System.out.println("twoSum2 " + Arrays.toString(result));

    }

    //暴力枚举
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int m=0; m< nums.length; m++){
            hashtable.put(nums[m], m);
        }

        for(int n=0; n<nums.length; n++){
            if(hashtable.containsKey(target - nums[n])){
                return new int[] {n, hashtable.get(target - nums[n])};
            }

        }
        return new int[0];
    }
}

