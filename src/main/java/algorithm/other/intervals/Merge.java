package algorithm.math.intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * @Author: bsy
 * @Date: 2023/1/8 23:13
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, (x, y) -> {
            if(x[0]==y[0]){
                return x[1] - y[1];
            }else{
                return x[0] - y[0];
            }
        });
        List<int[]> res = new LinkedList<>();


        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];
            //交叉和覆盖
            if(cur[0]<=right && cur[1]>right){
                right = cur[1];
            };
            if(cur[0]>right){
                int[] tmp = new int[]{left, right};
                res.add(tmp);
                left = cur[0];
                right = cur[1];

            }
            if(i==intervals.length-1){
                int[] tmp = new int[]{left, right};
                res.add(tmp);
            }
        }
        return res.toArray(new int[0][]);
    }

    public int[][] merge2(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, (x, y) -> {
            if(x[0]==y[0]){
                return x[1] - y[1];
            }else{
                return x[0] - y[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();


        res.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];
            int[] last = res.getLast();
            // 覆盖
            if(cur[1]<=last[1]){continue;}
            //交叉
            if(cur[0]<=last[1]){
                last[1] = Math.max(cur[1], last[1]);
                res.removeLast();
                res.add(last);
            }else{
                // 分割
                res.add(cur);
            }
        }
        return res.toArray(new int[0][]);
    }
    public static void main(String[] args){
//        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10},{15, 18}};
        int[][] arr = new int[][]{{1, 4}, {4, 5}};
        Merge merge = new Merge();
        int[][] res = merge.merge2(arr);
        for(int i=0; i<res.length; i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
