package algorithm.array;

/**
 * @Description: 删除有序数组的重复项，返回数组的长度
 * 后面元素和前面元素相等，就不操作，若不相等，则前后元素替换；对于第一个位置，元素相等不操作，包含规则内；
 * 使用双指针技巧，慢指针前一个元素，快指针指定后面元素
 * @Author: bsy
 * @Date: 2022/12/1 11:01
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums){
        // bad case
        if(nums.length==0){
            return 0;
        }

        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
