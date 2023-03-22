package algorithm.sort.binary;

/**
 * @Description: 二分右侧边界查找
 * @Author: bsy
 * @Date: 2022/12/1 21:57
 */
public class RightBoundSearch {

    public int rightBoundSearch(int[] nums, int target){
        if(nums.length==0 || nums[0] > target || nums[nums.length - 1] < target){
            return -1;
        }

        int left=0, right=nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }

        return nums[right]==target? right:-1;
    }
}
