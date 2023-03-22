package algorithm.string.twoString;

import java.util.ArrayList;

/**
 * @Description: 判断一个短字符串是否是另一个长字符串的子序列
 * @Author: bsy
 * @Date: 2023/1/9 18:43
 */
public class IsSubsequence {
    boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        //双指针，好处是根据情况进行非线性扫描
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i +=1;
                j+=1;
            }else{
                j+=1;
            }
        }
        return i==s.length();
    }

    boolean isSubsequence2(String s, String t){
        int m = s.length();
        int n = t.length();
        // 构造哈希表, 元素是ArrayList<Integer>的数组
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if(index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }

        // 字符串t上的指针，字符串t不再是线性扫描，而是基于二分查找的跳跃性查找
        int j = 0;
        // 针对s字符串
        for(int i=0; i<m; i++){
            char cur = s.charAt(i);
            //t中不存在改字符
            if(index[cur]==null){return false;}
            //找到索引
            int pos = leftBound(index[cur], j);
            if(pos==-1){return false;}
            // 存在于pos位置，调到t串的下一个位置
            j = index[cur].get(pos)+ 1;
        }

        return true;
    }

    /**
     *查找左侧边界的二分查找, 即使没有找到，返回比target大的索引
     */
    int leftBound(ArrayList<Integer> arr, int target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > arr.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == arr.size()) {
            return -1;
        }
        return left;
    }


    public static void main(String[] args) {
        String a = "abc";
        String b = "crafggbccc";
        IsSubsequence isSubsequence = new IsSubsequence();
        boolean subsequence = isSubsequence.isSubsequence2(a, b);
        System.out.println(subsequence);

    }
}
