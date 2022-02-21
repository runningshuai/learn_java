package dataStructure;

public class removeElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 233, 56, 2, 78, 233, 456, 789};
        int length = removeValue(nums, 233);
        System.out.println("the length after remove value is " + length);
        for(int i=0; i<nums.length; i++) System.out.println(nums[i]);
    }
    //快慢指针，一个用来快速扫描(快指针)，判断是否和目标相等，一个用来辅助覆盖(慢指针)
    public static int removeValue(int[] nums, int target){
        int slowIndex = 0;
        // 一个用来快速扫描(快指针)
        for(int fastIndex=0; fastIndex <= nums.length - 1; fastIndex++){
            // 直到遇到不同,进行替换
            if(target != nums[fastIndex]){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            //相等的时候，一直往前走
        }
        return slowIndex;
    }
}
