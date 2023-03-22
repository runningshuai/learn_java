package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 06, N字型变换数组
 * @Author: bsy
 * @Date: 2023/2/28 10:04
 */
public class ConvertZ {
    public String convert(String s, int numRows){
        if(numRows < 2){return s;}
        List<StringBuilder> list = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            list.add(new StringBuilder());
        }
        int i=0, j=0;
        // 用来转向
        int flag=-1;
        while(j < s.length()){
            char c = s.charAt(j);
            list.get(i).append(c);
            //转向
            if(i==0 || i == numRows -1){flag = -flag;}
            i+=flag;
            j+=1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb:list){
            res.append(sb);
        }

        return res.toString();
    }
}
