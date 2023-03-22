package algorithm.math;

/**
 * @Description: 阶乘函数后k个零，给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。
 * 要么0个要么5个，https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/solution/by-mcdull0921-fvbg/
 * @Author: bsy
 * @Date: 2023/1/11 11:22
 */
public class PreimageSizeFZF {
    public int preimageSizeFZF(int k) {
        long left = 4L*k;
        long right = 5L*k;
        while(left <= right){
            long mid = left + (right - left)/2;
            long size = sizeOf0(mid);
            if(size == k){
                return 5;
            }
            if(size > k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return 0;
    }

    int sizeOf0(long n){
        int res = 0;
        while(n>0){
            res += n/5;
            n /=5;
        }
        return res;
    }

    public static void main(String[] args) {
        PreimageSizeFZF preimageSizeFZF = new PreimageSizeFZF();
        int i = preimageSizeFZF.preimageSizeFZF(1000000000);
        System.out.println(i);
    }


}
