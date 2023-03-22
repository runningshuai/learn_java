package algorithm.sort.normal;

/**
 * @Description: 冒泡排序, 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 * @Author: bsy
 * @Date: 2022/12/8 17:36
 */
public class BubbleSort {
    int[] bubbleSort(int[] array){
        if(array.length==0){
            return array;
        }

        for(int i=0; i<array.length; i++){
            //后面排序好了，不需要继续排
            for(int j=0; j<array.length -1 -i ; j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 1, 3,20};
        BubbleSort bubbleSort = new BubbleSort();
        int[] ints = bubbleSort.bubbleSort(nums);

        for(int each:ints){
            System.out.print(each + " ");
        }
    }
}
