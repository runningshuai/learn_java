package algorithm.backTrack;

/**
 * @Description: 数组循环，改成递归的形式
 * @Author: bsy
 * @Date: 2023/1/5 15:22
 */
public class ArrayRecursion {

    void reverse(int[] nums, int i){
        if(i>=nums.length){
            return;
        }
        System.out.println("recursion: " + nums[i]);
        reverse(nums, i+1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
        ArrayRecursion arrayRecursion = new ArrayRecursion();
        arrayRecursion.reverse(nums, 0);
    }
}
