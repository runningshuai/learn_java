package ds.sort.dynamicPogram;


/**
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * 我们把一个字符串编码成一串数字，再考虑逆向编译成字符串。
 * 由于没有分隔符，数字编码成字母可能有多种编译结果，
 * 例如 11 既可以看做是两个 'a' 也可以看做是一个 'k' 。
 * 但 10 只可能是 'j' ，因为 0 不能编译成任何结果。
 * 现在给一串数字，返回有多少种可能的译码结果
 */
public class translate {

    public static  int solve (String nums) {
        // write code here
        if(nums.equals("0")) return 0;
        //排除只有一种可能的10 和 20
        if(nums.equals("10") || nums.equals("20")) return 1;
        //当0的前面不是1或2时，无法译码，0种
        for(int i=1; i<nums.length(); i++){
            if(nums.charAt(i)=='0'){
                //不满足'1'且不满足'2'，不能用或，后面的式子会满足情况
                if( nums.charAt(i-1) !='1' && nums.charAt(i-1) !='2'){
                    return 0;
                }
            }
        }

        int a=1;
        int b=1;
        int res = 1;
        // 11~19, 21~26
        for(int j=1; j< nums.length(); j++){
            // 两种情况
            if((nums.charAt(j-1)=='1' && nums.charAt(j)!='0')||
            (nums.charAt(j-1)=='2'&& nums.charAt(j)>'0' && nums.charAt(j)<'7')){
                res = a + b;
            } else{
                res = b;
            }
            a = b;
            b = res;
        }

        return res;

    }

    public static void main(String[] args) {
//        String s = "31717126241541717";
        String s = "72416145196211821232022471311148103136128331523141061051992231223";
        int solve = solve(s);
        System.out.println(solve);
    }

}
