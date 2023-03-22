package algorithm.divideAndConquer;

import java.util.Arrays;

/**
 * @Description: 归并排序，分治算法的利用，参考  https://developer.aliyun.com/article/634671
 * @Author: bsy
 * @Date: 2023/1/6 17:26
 */
public class MergeSort {
    int[] mergeSort(int[] array){
        if(array.length<=1){
            return array;
        }
        sort(array, 0, array.length-1);
        return array;

    }

    void sort(int[] array, int low, int high){
        if(low<high){
            int mid = (low + high)/2;
            // 分开
            sort(array, low, mid);
            sort(array, mid+1, high);
            // 合并
            merge(array, low, mid, high);
        }
    }

    void merge(int[] array, int low, int mid, int high){
        //合并后的索引
        int[] tmp = new int[high - low + 1];
        //左半边数组开始
        int i=low;
        //右半边数组开始
        int j=mid + 1;
        //合并后数据的索引
        int k=0;

        while(i<=mid&&j<=high){
            if(array[i]<=array[j]){
                tmp[k++] = array[i++];
            }else{
                tmp[k++] = array[j++];
            }
        }

        while(i<=mid){
            tmp[k++] = array[i++];
        }
        while(j<=high){
            tmp[k++] = array[j++];
        }
        //复制到原数组
        for(int l=0; l<tmp.length; l++){
            array[low+l] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 6, 5,8 ,9,4};
        MergeSort mergeSort = new MergeSort();
        int[] ints = mergeSort.mergeSort(nums);
        System.out.print(Arrays.toString(ints));
    }
}
