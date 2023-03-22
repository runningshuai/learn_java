package algorithm.array;

/**
 * @Description: 左边界二分查找
 * @Author: bsy
 * @Date: 2023/1/9 22:32
 */
public class LeftBinarySearch {
    public int leftBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        // 取不到右边界
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid]==target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else if(nums[mid] > target){
                // 若是取right = mid -1, 下一次循环left<right=mid-1,left最大mid-2, 会漏掉mid-1
                right = mid;
            }
        }
        // 没有找到，target 比所有数都大，返回 -1
        if(left == nums.length) {
            return -1;
        }
        //若是比target小
        return nums[left]==target?left:-1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,3,3,3,3,3,4,5,6};
        LeftBinarySearch binarySearch = new LeftBinarySearch();
        int res = binarySearch.leftBinarySearch(nums, 2);
        System.out.println(res);
    }
}
