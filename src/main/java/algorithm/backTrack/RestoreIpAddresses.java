package algorithm.backTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 复原ip地址
 * @Author: bsy
 * @Date: 2023/1/6 11:00
 */
public class RestoreIpAddresses {

    List<String> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4){
            return res;
        }
        traverse(s, 0);
        return res;

    }

    /**
     * dfs
     * @param s 字符串
     * @param i 字符串扫描的位置
     */
    void traverse(String s, int i){
        //结果返回
        if(i==s.length()&&track.size()==4){
            String ip = concat(track);
            res.add(ip);
            return;
        }
        //超过4个
        if(track.size()>4){
            return;
        }
        //剩余的字符过长
        if((4-track.size())*3 + i <s.length()){
            return;
        }

        //有3种选择
        for(int j=1; j<=3; j++){
            if(i + j > s.length()){
                return;
            }
            String cur = s.substring(i, i + j);
            if(cur.length()>=2&&cur.charAt(0)=='0'){
                return;
            }
            if(Integer.parseInt(cur)>255){
                return;
            }
            track.add(cur);
            traverse(s, i + j);
            track.removeLast();
        }

    }

    /**
     * 列表拼接
     */
    String concat(LinkedList<String> list){
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            sb.append(list.get(i));
            if(i!=size-1){
                sb.append('.');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses("101023");
        System.out.println(strings);
    }
}
