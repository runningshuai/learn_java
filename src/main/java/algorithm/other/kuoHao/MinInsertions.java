package algorithm.other.kuoHao;

/**
 * @Description: 平衡括号字符串的最少插入次数，一个左括号需要2个右括号
 * @Author: bsy
 * @Date: 2023/1/9 16:57
 */
public class MinInsertions {

    public int minInsertions(String s) {
        //总的插入次数，包括左和右
        int totalCnt = 0;
        // 需要补充的右括号数，指针不断扫描，需要的右括号也不断在变化，needRight + 字符串的右括号数=实际的右括号数
        int needRight=0;
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur=='('){
                needRight +=2;
                // 遇到一个新的的左括号，之前的左括号都是完全匹配的
                if(needRight %2==1){
                    //需要补充1个右括号
                    totalCnt +=1;
                    //插入了1个右括号，右括号的需求减1
                    needRight -=1;
                }
            }else{
                //遇到右括号, 理想状态的右括号需要减1
                needRight -=1;
                // 右括号过多
                if(needRight == -1){
                    //需要插入左括号
                    totalCnt +=1;
                    // 还需要一个右括号
                    needRight = 1;
                }
            }
        }
        //剩余的needRight若没有匹配到，需要插入
        return totalCnt + needRight;
    }
}
