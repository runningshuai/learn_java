package algorithm.array;

/**
 * @Description: 二分查找，采用左右闭区间，响应的while循环应该取等于号，可以取到right
 * @Author: bsy
 * @Date: 2023/1/9 22:11
 */
public class BinarySearch {

    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        BinarySearch binarySearch = new BinarySearch();
        int res = binarySearch.binarySearch(nums, 5);
        System.out.println(res);
    }
}
