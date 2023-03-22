package algorithm.math;

/**
 * @Description: 输入一个非负整数 n，请你计算阶乘 n! 的结果末尾有几个 0。
 * 每隔5个有一个5，每隔25个有2个5（被5计算了1次，还有1次未计算），每隔125个有3个5(5,25已经计算出来了，还有一次未计算)
 * 每隔5个共有n/5个，每隔25共有n/(5^2)，一直到n
 * @Author: bsy
 * @Date: 2023/1/10 23:29
 */
public class TrailingZeroes {
    public int trailingZeroes(int n){
        int res = 0;
        while(n>0){
            res += n/5;
            //n之前除了5，加上这次的5，累加出以5
            n /=5;
        }

        return res;
    }
}
