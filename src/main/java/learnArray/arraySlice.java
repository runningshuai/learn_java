package learnArray;


import java.util.Arrays;

public class arraySlice {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
//        s := arr[1:3];
        int[] ints = Arrays.copyOfRange(arr, 3, arr.length);

        for(int i=0; i<ints.length; i++){
            if(i==ints.length-1){
                System.out.print(ints[i]);
            }else{
                System.out.print(ints[i] + " ");
            }
        }
    }
}
