package algorithm.math.intervals;

import java.util.LinkedList;

/**
 * @Description: 区间列表的交集,参考 https://www.cnblogs.com/labuladong/p/13975851.html
 * @Author: bsy
 * @Date: 2023/1/9 11:34
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //双指针
        int i=0;
        int j=0;
        LinkedList<int[]> res = new LinkedList<>();
        while(i<firstList.length&&j<secondList.length){
            int[] first = firstList[i];
            int[] second = secondList[j];
            //存在交集
            if(first[1]>=second[0] && second[1]>=first[0]){
                int left = Math.max(first[0], second[0]);
                int right = Math.min(first[1], second[1]);
                res.add(new int[]{left, right});
            }
            //谁小谁前进一步
            if(first[1]>second[1]){
                j +=1;
            }else{
                i+=1;
            }
        }
        return res.toArray(new int[0][]);
    }
}
