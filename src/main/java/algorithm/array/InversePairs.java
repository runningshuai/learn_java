package algorithm.array;

/**
 * @Description:
 * @Author: bsy
 * @Date: 2023/2/1 18:41
 */
public class InversePairs {
    int cnt=0;
    public int inversePairs(int [] array) {
        if(array.length != 0){
            divide(array,0,array.length-1);
        }
        return cnt;
    }

    public void divide(int[] array, int start, int end){
        if(start == end){
            return;
        }
        int mid = start + (end - start)/2;
        divide(array, start, mid);
        divide(array, mid+1, end);
        merge(array, start, mid, end);

    }

    public void merge(int[] array, int start, int mid, int end){
        //合并后的数组
        int[] tmp = new int[end - start + 1];
        int i=start, j=mid + 1, k=0;

        while(i<=mid && j<=end){
            //前比后大，有逆序对，后面的后移
            if(array[i]>array[j]){
                cnt = (cnt + mid - i + 1)%1000000007;
                // 合并的结果
                tmp[k++] = array[j++];
            }else{
                //前比后小，无逆序对
                tmp[k++] = array[i++];
            }
        }
        while(i<=mid){
            tmp[k++] = array[i++];
        }
        while(j<=end){
            tmp[k++] = array[j++];
        }

        //搬到原数组
        for(k=0; k<tmp.length; k++){
            array[start + k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();
        int[] array = new int[]{1,2,3,4,5,0};
        int i = inversePairs.inversePairs(array);
        System.out.println(i);

    }
}
