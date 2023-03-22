package algorithm.sort.normal;

import java.util.Arrays;

/**
 * @Description: 归并排序 这个版本的归并排序不对
 * @Author: bsy
 * @Date: 2022/12/9 17:48
 */
public class MergeSort {
    int[] mergeSort(int[] array){
        if (array.length < 2) {return array;}
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(left, right);
    }

    int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        for(int index=0, i=0, j=0; index < result.length; index ++){
            if(i>=left.length){
                result[index] = right[j++];
            }else if(j>=right.length){
                result[index] = left[i++];
            }else if(left[i] < right[j]){
                result[index] = left[i++];
            }else{
                result[index] = left[j++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 6, 5,8 ,9,4};
        MergeSort mergeSort = new MergeSort();
        int[] ints = mergeSort.mergeSort(nums);
        System.out.print(Arrays.toString(ints));
    }
}
