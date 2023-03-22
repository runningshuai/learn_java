package algorithm.sort.binary;

/**
 * @Description: 二分左侧边界查找
 * @Author: bsy
 * @Date: 2022/12/1 20:11
 */
public class LeftBoundSearch {

    public int leftBoundSearch(int[] nums, int target){
        //bad case
        if(nums.length==0 || target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }


        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                //这里不返回，而是步步逼近左侧, left不变，right逐步减小进行逼近
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return nums[left] == target ? left : -1;
    }
}
