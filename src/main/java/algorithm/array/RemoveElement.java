package algorithm.array;

/**
 * @Description: 删除数组中值为x的元素，返回数组长度
 * 不重复的元素需要搬到前面去，需要快慢指针，为了兼顾头一个元素是要删除的x,需要先移动元素后指针前进
 * @Author: bsy
 * @Date: 2022/12/1 11:19
 */
public class RemoveElement {

    public int removeElement(int[] nums, int x){
        if(nums.length==0){
            return 0;
        }

        int slow = 0, fast = 0;
        while(fast < nums.length){
            // 需要不相等的元素，所以搬到前面去
            if(nums[slow] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
