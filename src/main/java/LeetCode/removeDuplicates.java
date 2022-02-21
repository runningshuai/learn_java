package LeetCode;

public class removeDuplicates {
    //有序数组去重，且不能增加新的空间
    public int removeDuplicates(int[] nums){
        if(nums.length == 0) return 0;
        //数组的第一个节点
        int i=0;
        for(int j = 1; j<nums.length; j++){
            if(nums[i]!=nums[j]){
                //应放在原来数组之后
                i++;
                nums[i] = nums[j];
            }
        }
        //返回数组长度
        return i + 1;
    }
}
