package algorithm.array;

/**
 * @Description: 最大子数组之和，采用滑动窗口解法
 * @Author: bsy
 * @Date: 2022/12/5 18:11
 */
        public class MaximumSubarray {
    int maximumSubarry(int[] nums){
        if(nums.length==0){
            return 0;
        }
        //大于0扩大窗口，小于0缩短窗口，在扩大窗口的时候更新最大值
        int left=0, right=0;
        int max = Integer.MIN_VALUE;
        int tmp=0;
        //不能用for,因为不是线性遍历
        while(right<nums.length){
            //扩大窗口
            tmp = tmp + nums[right];
            right = right+1;
            //更新窗口
            max = Math.max(tmp, max);
            //收缩窗口
            while(tmp < 0){
                tmp = tmp - nums[left];
                left = left - 1;
            }
        }
        return max;

    }
}
