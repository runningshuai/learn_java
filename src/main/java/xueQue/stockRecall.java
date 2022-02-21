package xueQue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class stockRecall {

    public static void main(String[] args) {
        String uid="7628719444";

        Map<String, Map<String, Double>> stockFavorLong = new HashMap<>();
        Map<String, Map<String, Double>> stockFavorShort = new HashMap<>();
        Map<String, Double> scoreLong = new HashMap<>();
        Map<String, Double> scoreShort = new HashMap<>();


        String redisKeyLong = "favorStock:Long:" + uid;
        String redisKeyShort = "favorStock:Short:" + uid;

        scoreLong.put("3301", 0.22);
        scoreLong.put("3302", 233222.4);
        scoreLong.put("3303", 456778899.34);
        scoreLong.put("3304", 89.0);
        scoreLong.put("3305", 189.0);
        stockFavorLong.put(redisKeyLong, scoreLong);

        scoreShort.put("3301", -0.2223);
        scoreShort.put("3303", -78.0);
        scoreShort.put("3305", -78888.0);
        scoreShort.put("3306", 12.0);
        scoreShort.put("3307", 345.0);
        scoreShort.put("3308", 34566666.0);
        stockFavorShort.put(redisKeyShort, scoreShort);


        String userId="7628719444";
        System.out.println("有一个用户来了...");
        String keyOfLong = "favorStock:Long:" + userId;
        String keyOfShort = "favorStock:Short:" + userId;

        Map<String, Double> userFavorStockLong = stockFavorLong.getOrDefault(keyOfLong, new HashMap<>());
        Map<String, Double> userFavorStockShort = stockFavorShort.getOrDefault(keyOfShort, new HashMap<>());

        System.out.println(String.format("user-> %s, favor stock is -> %s", redisKeyLong, userFavorStockLong.toString()));
        System.out.println(String.format("user-> %s, favor stock is -> %s", redisKeyShort, userFavorStockShort.toString()));

        utils util = new utils();
        int limit=20;
        List<String> result = util.getFavorStockList(userFavorStockLong, userFavorStockShort, limit);

        System.out.println("--------------->召回结果");
        System.out.println(result.toString());
    }

}
