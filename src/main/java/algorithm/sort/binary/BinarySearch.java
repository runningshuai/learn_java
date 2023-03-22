package algorithm.sort.binary;

/**
 * @Description: 经典的二分查找，返回索引的位置，找不到返回-1
 * @Author: bsy
 * @Date: 2022/12/1 19:44
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        // 闭区间写法[left, right]
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,4,4,5,6,7};

        BinarySearch binarySearch = new BinarySearch();
        int res = binarySearch.binarySearch(nums, 4);
        System.out.println(res);
    }
}
