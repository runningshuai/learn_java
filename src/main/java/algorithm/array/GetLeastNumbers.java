package algorithm.array;

import java.util.Arrays;

/**
 * @Description: 最小的k个数，使用快排的思想，只取前k个数
 * 时间复杂度O(N)
 * @Author: bsy
 * @Date: 2023/2/24 15:21
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int [] input, int k) {
        if(input.length < k){return input;}
        return quickSort(input, 0, input.length - 1, k);
    }

    public int[] quickSort(int[] arr, int left, int right, int k){
        int i = left;
        int j = right;
        int pivot = arr[left];
        while(i < j){
            while(arr[j] > pivot){ j-=1;}
            while(arr[i] < pivot){ i+=1;}

            swap(arr, i, j);
        }
        swap(arr, left, i);
        if(k<i) {return quickSort(arr, left, i-1, k);}
        if(k>i) {return quickSort(arr, i+1, right, k);}

        return Arrays.copyOf(arr, k);
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] input = {4,5,9,0,12,67,34,6};
        int[] res = getLeastNumbers.getLeastNumbers(input, 5);
        System.out.println(Arrays.toString(res));
    }
}
