package algorithm.dp;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description: 购物单
 * @Author: bsy
 * @Date: 2023/3/19 16:29
 */
public class PurchaseList {
    /**
     * @param money 总金额
     * @param cnt 最大的购物数
     * @param list 购物列表，第一列价值，第二列是权重， 第三列，0是购物的主件， 大于0是主件id
     * @return
     */
    public void purchaseList(int money, int cnt, int[][]list){
        //只有主件
        HashMap<Integer, int[]> primary  = new HashMap<Integer, int[]>();
        // 主附件关系
        HashMap<Integer, LinkedList<LinkedList<Integer>>> second  = new HashMap<Integer, LinkedList<LinkedList<Integer>>>();

        for(int i=1; i<list[0].length; i++){
            if(list[i][2] == 0){
                primary.put(i, new int[]{list[i][0], list[i][1]});
            }else{
                second.putIfAbsent(i, new LinkedList<>());
                LinkedList<Integer> tmp= new LinkedList<>();
                tmp.add(list[i][0]);
                tmp.add(list[i][1]);
                second.get(i).add(tmp);
            }
        }

        // 价格
        int[][] w = new int[cnt][];
        // 满意度
        int[][] v = new int[cnt][];



    }
}
