package ds.sort.dynamicPogram;

public class JumpFloor {
    /**
     * 一只青蛙，可以跳1次、2次，问跳n阶台阶，有多少种跳法
     * 当前状态用上一状态进行表示，即状态转移方程
     * 该问题可以转化成子问题
     * @param n
     * @return
     */
    public static int jumpFloor(int n){
        if(n<=0) return 0;
        if(n<=2) return n;
        int cur=3;
        int lastOne = 2;
        int lastTwo = 1;

        for (int i=3; i<=n; i++){
            cur = lastOne + lastTwo;
            lastTwo = lastOne;
            lastOne = cur;
        }
        return cur;
    }

    /**
     * 变态跳楼梯，可以n种跳法
     * d_i = 2*d_{i-1}
     * 2^{i-1}
     * @param n
     * @return
     */
    public static int jumpFloorK(int n){
        if(n<=1) return n;
        return 2<<n-2;

    }

    public static void main(String[] args) {
        int n = 6;
        int i = jumpFloorK(n);
        System.out.println(n);
        System.out.println(i);
    }

}
