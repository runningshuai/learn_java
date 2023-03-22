package algorithm.array;

import java.util.Arrays;

/**
 * @Description: 非递减序列，找出和为sum的两个数，数组下标从1开始
 * @Author: bsy
 * @Date: 2022/12/1 22:46
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target){
        int left=0, right=nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum > target){
                right = right - 1;
            }else if(sum < target){
                left = left + 1;
            }else{
                return new int[]{left + 1, right + 1};
            }
        }
        //没找到
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));
    }
}
