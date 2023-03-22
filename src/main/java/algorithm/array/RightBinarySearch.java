package algorithm.array;

/**
 * @Description: 右边界二分查找
 * @Author: bsy
 * @Date: 2023/1/10 1:23
 */
public class RightBinarySearch {
    public int rightBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left <right){
            int mid = left + (right - left)/2;
            if(nums[mid]==target){
                // 左区间可以取到，需要往前进一步
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        if(left-1<-0) {return -1;}
        return nums[left - 1]==target?left -1:-1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,3,3,3,3,4,5,6};
        RightBinarySearch binarySearch = new RightBinarySearch();
        int res = binarySearch.rightBinarySearch(nums, 7);
        System.out.println(res);
    }
}
