package algorithm.array.twoPoints;

/**
 * @Description: 盛最多水的容器
 * @Author: bsy
 * @Date: 2023/2/23 21:19
 */
public class MaxArea {
    public int maxArea (int[] height) {
        // write code here
        if(height.length<=1){return 0;}
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int cur;

        while(left <= right){
            // 盛多少水是由最短的板决定的，所以要找短的
            cur = Math.min(height[left], height[right]) * (right - left);
            // 遍历寻找最大的
            res = Math.max(res, cur);

            if(height[left] <= height[right]){
                left += 1;
            }else{
                right -= 1;
            }
        }

        return res;
    }
}
