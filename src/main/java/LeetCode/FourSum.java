package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 18四数之和
 * @Author: bsy
 * @Date: 2023/3/1 9:42
 */
public class FourSum {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){return res;}
        Arrays.sort(nums);

        // 固定两个指针
        for(int i=0; i< nums.length; i++){
            if(nums[i]>0 && nums[i] > target){return res;}
            if(i>0 && nums[i] == nums[i-1]){continue;}

            for(int j=i+1; j< nums.length; j++){
                // 这一步不行，nums[i] < 0也是可以的
                // if(nums[j]> 0 && nums[j] > target){break;}
                if(j>i+1 && nums[j] == nums[j-1]){continue;}

                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] +nums[left] +nums[right];
                    if(sum > target){
                        right -= 1;
                    }else if(sum < target){
                        left += 1;
                    }else{
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left += 1;
                        right -= 1;
                        while(left<right && nums[left]==nums[left-1]){left += 1;}
                        while(left<right && nums[right]==nums[right+1]){right -= 1;}
                    }
                }
            }
        }
        return res;
    }

}
