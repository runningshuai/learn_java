package ds.sort.treeSeries;

import java.util.ArrayList;

public class HasPathSumAll {

    //存储最终的结果，只能全局变量
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    //要维护的一条路径的结果，也只能全局变量，且只维护一条路径
    ArrayList<Integer> tmp = new ArrayList<>();
    public  ArrayList<ArrayList<Integer>> hasPathSumAll (TreeNode root, int sum) {
        if(root==null) return new ArrayList<>();
        pathTree(root, sum);

        return result;


    }

    void pathTree(TreeNode root, int sum){
        //找满足条件的路径，所以递归条件找满足条件的，其他不满足的继续递归
        tmp.add(root.val);
        sum -= root.val;
        if(root.left==null && root.right==null && sum==0) result.add(new ArrayList<>(tmp));
        //其他不满足，没有可以直接返回fase的，继续试探
        if(root.left != null) pathTree(root.left, sum);
        if(root.right != null) pathTree(root.right, sum);

        //走到这里，说明递归已经到底(root.left==null && root.right==null)，还没找到有合适的路径
        tmp.remove(tmp.size()-1);
    }
}
