package algorithm.other.kuoHao;

/**
 * @Description: 使括号有序的最少添加。记录需要的左括号和右括号数
 * @Author: bsy
 * @Date: 2023/1/9 16:31
 */
public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int needLeft = 0;
        int needRight = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                needRight +=1;
            }else{
                needRight -= 1;

                //右括号过多，需要左括号
                if(needRight==-1){
                    //补充左括号
                    needLeft +=1;
                    needRight = 0;
                }
            }
        }
        return needLeft + needRight;
    }

    public static void main(String[] args) {
        String s = "())(";
        MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();
        int res = minAddToMakeValid.minAddToMakeValid(s);
        System.out.println(res);
    }
}
