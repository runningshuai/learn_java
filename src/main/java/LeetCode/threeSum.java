package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 三数之和，
 * https://leetcode.cn/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
 * @Author: bsy
 * @Date: 2023/2/28 17:47
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] arr){
        if(arr.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(arr);
        List<List<Integer>> result = new LinkedList<>();
        for(int k=0; k<arr.length - 2; k++){
            if(arr[k] > 0){break;}
            if(k>0 && arr[k]==arr[k-1]){continue;}

            int i = k + 1;
            int j = arr.length - 1;
            while(i < j){
                int s = arr[k] + arr[i] + arr[j];
                if(s<0){
                    // 收缩左边界
                    i += 1;
                    // 前进一步和前进之前的一步，其值若是相等，相当于白移动，还得继续移动
                    while(i<j && arr[i]==arr[i-1]) { i+=1;}
                }else if (s > 0){
                    j -= 1;
                    while(i<j && arr[j] == arr[j+1]){j -= 1;}
                }else{
                    List<Integer> tmp = new ArrayList<>(Arrays.asList(arr[k], arr[i], arr[j]));
                    result.add(tmp);
                    i += 1;
                    j -= 1;
                    // 校验是否和上一步相等，若相等需要多次移动，找到一个不相等的值
                    while(i<j && arr[i]==arr[i-1]) { i+=1;}
                    while(i<j && arr[j] == arr[j+1]){j -= 1;}

                }
            }
        }

        return result;
    }
}
