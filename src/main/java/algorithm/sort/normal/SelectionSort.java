package algorithm.sort.normal;

/**
 * @Description: 选择排序, 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 * @Author: bsy
 * @Date: 2022/12/9 15:34
 */
public class SelectionSort {

    int[] selectionSort(int[] array){
        if(array.length==0){
            return array;
        }

        for(int i=0; i<array.length; i++){
            int minIndex = i;
            //寻找最小的位置
            for(int j=i; j<array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }

            //交换
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }
}
