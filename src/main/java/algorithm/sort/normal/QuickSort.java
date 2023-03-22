package algorithm.sort.normal;

/**
 * @Description: 快速排序
 * https://blog.csdn.net/Hackeryuan/article/details/122466548?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-122466548-blog-122481079.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-122466548-blog-122481079.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=1
 * @Author: bsy
 * @Date: 2022/12/11 17:58
 */
public class QuickSort {
    int[] quickSort(int[] array){
        if(array.length<=1){
            return array;
        }
        partition(array, 0, array.length - 1);
        return array;
    }

    void partition(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int pivot = array[low];
        int i=low, j=high;
        while(i<j){
            while(array[i]<=pivot && i<j) {++i;}
            while(array[i]>=pivot && i<j) {++j;}

            //交换
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        //完成一轮排序，把基准移到中间值得位置
        array[low] = array[i];
        array[i] = pivot;
        //分别对基准两端的数据进行快排
        partition(array, low, i-1);
        partition(array, i+1, high);
    }

}
