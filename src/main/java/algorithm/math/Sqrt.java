package algorithm.math;

/**
 * @Description: 实现开平方根
 * @Author: bsy
 * @Date: 2022/12/13 15:58
 */
public class Sqrt {

    int sqrt(int x){
        if(x<=0){return 0;}
        int i=0, j=x;
        int ans=-1;
        while(i<=j){
            int mid = i + (j-i)/2;

            if((long) mid*mid<=x){
                ans = mid;
                i = i + 1;
            }else{
                j = j - 1;
            }
        }

        return ans;
    }

    float sqrt(float x, float e){
        if(x<=0 || e<0){return 0;}
        float low=0, high = x;
        while(low<=high){
            float mid = low + (high - low)*0.5f;
            System.out.println(mid);
            if(Math.abs(mid*mid - x) <=e){
                return mid;
            }else if(mid*mid - x > e){
                high = mid;
            }else if(mid*mid - x < e*(-1)){
                low = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        float sqrt1 = sqrt.sqrt(8.0f, 0.001f);
        System.out.println(sqrt1);
    }

}
