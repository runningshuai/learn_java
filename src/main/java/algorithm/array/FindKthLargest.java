package algorithm.array;

import java.util.Arrays;

/**
 * @Description: 数组中的第 k 大的数字
 * @Author: bsy
 * @Date: 2023/3/21 20:45
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k){return -1;}
        return quickSort(nums, 0, nums.length -1, nums.length -k);
    }

    public int quickSort(int[] arr, int left, int right, int k){
        int index = partition(arr, left, right);

        if(index==k){return arr[index];}

        if(index > k){
            return quickSort(arr, left, index - 1, k);
        }else{
            return quickSort(arr, index + 1, right, k);
        }

    }


    public int partition(int[] arr, int left, int right){
        int i=left;
        int j=right;

        int pivot = arr[left];
        while(i < j){
            // 一定要右侧的先行， 否则数据不对
            while(arr[j] >= pivot && i<j){j-=1;}
            while(arr[i] <= pivot && i<j){i+=1;}
            if(i<j){swap(arr, i, j);}
        }
        System.out.println(Arrays.toString(arr));
        swap(arr, i, left);
        System.out.println(Arrays.toString(arr));

        return i;

    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] arr = new int[]{3,2,1,5,6,4};
        int k=2;
        int res = findKthLargest.findKthLargest(arr, k);
        System.out.println(res);
    }
}
