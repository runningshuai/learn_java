package algorithm.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:  打开转盘锁
 * @Author: bsy
 * @Date: 2023/1/6 9:47
 */
public class OpenLock {
    int openLock(String[] deadends, String target){
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int step = 0;
        for(String s:deadends){
            visited.add(s);
        }
        q.offer("0000");

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size;i++){
                String poll = q.poll();
                if(visited.contains(poll)){
                    continue;
                }else{
                    //对所有的状态做个备忘录，以免重复计算
                    visited.add(poll);
                }
                if(poll.equals(target)){
                    return step;
                }

                for(int j=0; j<4; j++){
                    String s = plusOne(poll, j);
                    if(!visited.contains(s)){
                        q.offer(s);
                    }
                    String s1 = MinusOne(poll, j);
                    if(!visited.contains(s1)){
                        q.offer(s1);
                    }

                }
            }
            //一层一层的广度优先遍历，就是最小的结果
            step++;
        }
        return -1;
    }




    /**
     * 在第i个位置加1
     * @param s 字符串
     * @param i 要操作的位置
     * @return 字符串
     */
    String plusOne(String s, int i){
        char[] chars = s.toCharArray();
        if(chars[i]=='9'){chars[i]='0';}
        chars[i]++;
        return new String(chars);
    }

    String MinusOne(String s, int i){
        char[] chars = s.toCharArray();
        if(chars[i]=='0'){chars[i]='9';}
        chars[i]--;
        return new String(chars);
    }
}
