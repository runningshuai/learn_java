package algorithm.backTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 给一个数组，有多少种组合; 给1-n的数，有多少种k个元素的组合；只需要收集子集的k层
 * @Author: bsy
 * @Date: 2023/1/5 17:51
 */
public class Combine {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        traverse(1, n, k);
        return res;
    }

    void traverse(int n, int k, int start){

    }
}
