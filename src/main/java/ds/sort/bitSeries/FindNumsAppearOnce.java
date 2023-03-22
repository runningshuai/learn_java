package ds.sort.bitSeries;

public class FindNumsAppearOnce {

    int[] FindNumsAppearOnce(int[] array){
        /*
        1、找出分组的数:a、数据异或 b、求最后一位不为1的数
        2、分组，分别异或，得出两个数
        3、结果排序
         */
        int a = 1;
        for(int i=0; i<array.length;i++){
            a ^= array[i];
        }
        int b=1;
        while((b&a)==0){b = b<<1;}

        int m=1;
        int n=1;
        for(int j=0 ; j<array.length; j++){
            if((array[j]&b)==0){
                m ^= array[j];
            }else{
                n ^= array[j];
            }
        }

        //交换
        int p;
        if(m>n){
            p = m;
            m = n;
            n = p;
        }

        return new int[]{m, n};
    }
}
