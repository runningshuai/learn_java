package ds.sort.dynamicPogram;

/**
 * 输入一个长度为n的整形数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1.
 * 求所有子数组的和的最大值。
 * 空间复杂度先O(n), 后O(1)
 * 整个的序列长一点，短一点，不影响解法；然后考虑序列递增
 * 思路：是否要之前的序列，而不是当前的序列否要当前的值
 */
public class FindGreatestSumOfSubArray {

    //O(N)解法
    public static int findGreatestSumOfSubArray(int[] arr){
        if(arr.length <=0) return 0;

        int[] dp = new int[arr.length];
        //序列从0开始
        dp[0] = arr[0];
        int max = dp[0];
        for(int i=1; i< arr.length; i++){
            //相当于只加正数，造成数据不连续
            //必须以i为结尾的数据，它的最大值，这个数据在中间就可以找到
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);

            max = max < dp[i]?  dp[i]: max;
        }
        for(int i=0; i < dp.length; i++){
            System.out.println(dp[i]);
        }
        return max;
    }

    //我们注意到方法一的动态规划在状态转移的时候只用到了i−1i-1i−1的信息，
    // 没有使用整个辅助数组的信息，因此可以将数组优化掉。
    public static int findGreatestSumOfSubArrayBest(int[] arr){
        if(arr.length <=0) return 0;
        int max = arr[0]; //保存最大值
        int last=arr[0]; //保存dp的i-1
        for(int i=1; i< arr.length; i++){
            last = Math.max(last + arr[i], arr[i]);
            max = last > max ? last:max;
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
        int res = findGreatestSumOfSubArrayBest(arr);
        System.out.println(res);
    }
}
