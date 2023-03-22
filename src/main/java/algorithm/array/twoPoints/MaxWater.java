package algorithm.array.twoPoints;

/**
 * @Description: 接雨水
 * @Author: bsy
 * @Date: 2023/2/23 21:11
 */
public class MaxWater {
    public long maxWater (int[] arr) {
        // write code here
        if(arr.length <= 1){return 0;}
        int res = 0;

        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while(left <= right){
            // 只要左边找到大的，再和后一个进行结合，就可以盛到水
            leftMax = Math.max(arr[left], leftMax);
            // 只要右边找到大的，就可以盛到水
            rightMax = Math.max(arr[right], rightMax);

            if(leftMax <= rightMax){
                res += leftMax - arr[left];
                left += 1;
            }else{
                res += rightMax - arr[right];
                right -= 1;
            }
        }

        return res;
    }
}
