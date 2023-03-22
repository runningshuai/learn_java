package algorithm.math.intervals;

import java.util.Arrays;

/**
 * @Description: 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * @Author: bsy
 * @Date: 2023/1/8 11:05
 */
public class RemoveCoveredIntervals {
    int removeCoveredIntervals(int[][] intervals){
        if(intervals.length <= 0){
            return 0;
        }
        // 按第一项排序，第1个相等，按第2项倒叙
        Arrays.sort(intervals, (x, y)->{
            if(x[0]==y[0]){
                return x[1] - y[1];
            }
            return x[0]-y[0];
        });
        //需要更新的左右取件
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for(int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];
            //完全覆盖
            if(cur[0]>=left&& cur[1]<=right){
                res +=1;
            }
            //存在交叉
            if(cur[0]>=left&& cur[1]>right){
                //保留最大的区间
                right = cur[1];
            }

            //不存在交叉
            if(cur[0]>=right&& cur[1]>right){
                left = cur[0];
                right = cur[1];
            }
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{1,4},{3,4}};
        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        int i = removeCoveredIntervals.removeCoveredIntervals(arr);
        System.out.println(i);
    }
}
