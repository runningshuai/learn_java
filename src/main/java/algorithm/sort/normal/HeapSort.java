package algorithm.sort.normal;

/**
 * @Description: 堆排序，大顶推-从小到大排序
 * @Author: bsy
 * @Date: 2022/12/12 12:21
 */
public class HeapSort {

    int[] heapSort(int[] array){
        if(array.length <=1){
            return array;
        }

        //初始化堆
        for(int i=0; i<=array.length/2 - 1; i++){
            adjustHeap(array, i, array.length);
        }
        //调整堆
        for(int j=array.length - 1; j>0; --j){
            // 交换
            int temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, j);
        }

        return array;

    }


    void adjustHeap(int[] array, int i, int length){
        int tmp = array[i];
        //只需要遍历左子节点
        for(int j = 2*i + 1; j<length; j = 2*j+1){
            //有右子节点
            if(j+1<length && array[j+1]>array[j]){
                ++j;
            }

            if(array[j] > tmp){
                array[i] = array[j];
                i=j;
            }else{
                break;
            }
        }
        array[i] = tmp;
    }
}
