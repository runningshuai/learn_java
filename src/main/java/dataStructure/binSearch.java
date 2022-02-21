package dataStructure;

public class binSearch {

    public static void main(String[] args) {
        int[] testArray = new int[]{1, 2, 6, 10, 23, 56, 78, 100};
        int index = search(testArray, 78);
        System.out.println("index is " + index);
    }

    public static int search (int[] nums, int target){
        if (target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }


}


