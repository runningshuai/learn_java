package ds.sort.dynamicPogram;

import java.util.Arrays;

public class FindGreatestSumOfSubArrayMiddle {

    public static int[] findGreatestSumOfSubArray (int[] array) {
        if (array.length <= 0) return new int[]{};
        int max = array[0]; //保存最大值
        int last = array[0]; //保存dp的i-1
        int m = 0;
        int n = m+1;

        int p = 0;
        int q = p+1;

        for (int i = 1; i < array.length; i++) {
            if(last + array[i] >= array[i]){
                last = last + array[i];
                q +=1;
            }else{
                last = array[i];
                p = i;
                q = p+1;
            }
            if(last >= max){
                max = last;
                m = p;
                n = q;
            }

        }
        return Arrays.copyOfRange(array, m, n);
    }

    public static void main(String[] args) {
//        int[] arr = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
//        int[] arr = new int[] {-1,1,2,1};
        int[] arr = new int[]{1,2,-3,4,-1,1,-3,2};
        int[] res = findGreatestSumOfSubArray(arr);
        for(int i=0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }
}
