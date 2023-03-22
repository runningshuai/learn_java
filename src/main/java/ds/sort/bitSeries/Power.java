package ds.sort.bitSeries;

public class Power {
    static double Power(double base, int exponent) {
        if(exponent == 0)return 1;
        if(exponent < 0){
            exponent = -1*exponent;
            base = 1/base;
        }

        double result = 1.0;
        while(exponent > 0){
            if((exponent & 1) ==1) {result *=base;}
            base *= base;
            exponent = exponent >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        double power = Power(1.2, 2);
        System.out.println(power);

    }
}
