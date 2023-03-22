package algorithm.divideAndConquer;

/**
 * @Description:
 * @Author: bsy
 * @Date: 2023/2/23 23:30
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        if(len1 + len2 == 0){return -1;}

        // 偶数是偏右的位置，奇数是正中间
        int mid = (len1 + len2)/2;
        int left=-1, right=-1;
        int i = 0, j=0;
        for(int k=0; k<=mid; k++){
            left = right;
            if(i<len1 && (j>=len2 || arr1[i] < arr2[j])){
                right = arr1[i];
                i += 1;
            }else{
                right = arr2[j];
                j+=1;
            }
        }

        if( (len1 + len2) % 2 == 0){
            return (left + right)*1.0/2;
        }else{
            return right;
        }

    }

    public static void main(String[] args) {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] s1 = new int[]{1, 2};
        int[] s2 = new int[]{3, 4};
        double res = solution.findMedianSortedArrays(s1, s2);
        System.out.println(res);
    }
}
