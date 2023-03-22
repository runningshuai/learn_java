package ds.sort.arrayStackQueueSeries;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个长度为 n 的数组 nums 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
 * 要求时间复杂度O(N),通常做法的时间复杂度是O(kN),所以要额外的辅助空间
 * 用双向单调队列，实时维护最大值，单独方法实时取
 * 1、维护单调的双向队列
 * 2、剔除过边界的数据
 * 3、取最大值
 * 由于每个元素最多进队和出队各一次，因此该算法时间复杂度为O(N)。
 * 队列为0的初始化，转化为非0的非初始化操作
 */
public class maxInWindows {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        //用户链表模拟双向单调队列
        LinkedList<Integer> wq = new LinkedList<>();
        for(int i=0; i<num.length; i++){
            //找到有序的位置，从尾部往头部找
            while(!wq.isEmpty()&&(num[wq.peekLast()]<=num[i])){
                wq.pollLast();
            }
            wq.addLast(i);

            //删除过时最大值
            if(wq.peekFirst()<=i-size){wq.pollFirst();}
            if(i >= size -1)result.add(num[wq.peekFirst()]);
        }
        return result;

    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        System.out.println(integers);
    }

}
