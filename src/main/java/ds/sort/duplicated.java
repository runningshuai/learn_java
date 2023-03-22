package ds.sort;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。
 * 存在不合法的输入的话输出-1
 * 解法：一个萝卜一个坑，只要找到一个就行。调整数组，让其index=value
 */
public class duplicated {

    public static int duplicate (int[] numbers) {
        // write code here
        int i=0;
        int tmp;
        while(i < numbers.length){
            if(numbers[i]==i){
                i++;
            }else{
                if(numbers[numbers[i]]==numbers[i]){
                    return numbers[i];
                }else{
                    int a= i;
                    int b = numbers[i];
                    tmp = numbers[a];
                    numbers[a] = numbers[b];
                    numbers[b] = tmp;
                }
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp=arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,1,0,2,5,3};
        int res = duplicate(arr);
        System.out.println(res);

    }
}
