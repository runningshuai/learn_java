package algorithm.math;

/**
 * @Description:
 * @Author: bsy
 * @Date: 2023/1/10 22:50
 */
public class JieCheng {
    public int jieCheng(int n){
        if(n<=2){
            return n;
        }
        return n*jieCheng(n-1);
    }

    public static void main(String[] args) {
        JieCheng jieCheng = new JieCheng();
        int res = jieCheng.jieCheng(10);
        System.out.print(res);
    }
}
