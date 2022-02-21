package api;

public class learnMath {
    public static void main(String[] args) {
        double logRes = Math.log(2);
        System.out.println("log2 " + logRes);

        double log10Res = Math.log10(10);
        System.out.println("log10Res " + log10Res);

        double logERes = Math.log(2.71828);
        System.out.println("logERes " + logERes);

        double log2Res = Math.log(2.71828)/Math.log(2);
        System.out.println("log2Res " + log2Res);

        double log2ResE = Math.log(2.71828)/0.693147;
        System.out.println(log2ResE);

    }

}
