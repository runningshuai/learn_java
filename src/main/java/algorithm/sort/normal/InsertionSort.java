package algorithm.sort.normal;

/**
 * @Description: 插入排序
 * @Author: bsy
 * @Date: 2022/12/9 16:36
 */
public class InsertionSort {

    int[] insertionSort(int[] array){
        if(array.length==0){
            return array;
        }

        int current;
        for(int i=0; i<array.length - 1; i++){
            int end = i;
            current = array[i+1];
            //寻找位置
            while(end > 0 && current < array[end]){
                array[i+1] = array[i];
                end = end - 1;
            }
            array[i+1] = current;
        }

        return array;

    }

}
