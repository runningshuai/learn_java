package algorithm.array;

/**
 * @Description: 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字，有一个数字重复。
 * 思路：位运算。构造1-n和s的数组，供2n数组，重复的数字x有3次（相当于1次），缺失y的有一次。
 * 1、异或，得到两数的xor 2、xor & (-xor)等到最低位 3、用最低位拆分出x,y到两组 4、遍历原数组判断是重复还是缺失
 * @Author: bsy
 * @Date: 2023/1/10 20:33
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor=0;
        //1.计算异或值
        for(int num:nums){
            xor ^= num;
        }
        for(int i=1; i<=n; i++){
            xor ^= i;
        }

        //2.求异或值得最低位
        int lowBit = xor &(-xor);

        //3.分成两部分
        int num0=0;
        int num1=0;
        for(int num:nums){
            if((lowBit&num)==0){
                num0 ^= num;
            }else{
                num1 ^= num;
            }
        }
        for(int i=1; i<=n; i++){
            if((lowBit&i)==0){
                num0 ^= i;
            }else{
                num1 ^= i;
            }
        }

        //4.判断哪个数字是重复，哪个数字是缺失值
        for(int num:nums){
            if(num==num0){
                return new int[]{num0, num1};
            }
        }
        return new int[]{num1, num0};

    }
}
