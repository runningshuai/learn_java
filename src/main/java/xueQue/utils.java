package xueQue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class utils {

    public double getStockFavorScore(double scoreLong, double scoreShort, double wLong, double wShort){
        return wLong*scoreLong + wShort*scoreShort;
    }

    public List<String> getFavorStockList(Map<String, Double> userFavorStockLong, Map<String, Double> userFavorStockShort, int limit){
        if(userFavorStockShort.isEmpty()){
            if(userFavorStockLong.size()>0){
                System.out.println("--------->只有长期兴趣");
                return userFavorStockLong.entrySet().stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .limit(limit)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
            }else{
                System.out.println("--------->长短期兴趣都没有");
                return new ArrayList<>();
            }
        }else {
            if (userFavorStockLong.size()>0) {
                System.out.println("--------->长短期兴趣都有");
                return favorStockList(userFavorStockLong, userFavorStockShort, limit);
            } else {
                System.out.println("--------->只有短期兴趣");
                return userFavorStockShort.entrySet().stream()
                        .filter(item -> item.getValue() > 0)
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .limit(limit)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
            }
        }
    }

    public List<String> favorStockList(Map<String, Double> userFavorStockLong, Map<String, Double> userFavorStockShort, int limit){
        //长短期兴趣分合并到一起
        Map<String, Double> stockScore = new HashMap<>();

        userFavorStockShort.entrySet().stream()
                .filter(item -> item.getValue()>0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if(userFavorStockShort.size()>0){
            userFavorStockShort.forEach((stock, value) -> {
                //log2
                double scoreShortNormal=Math.log(1+value)/0.693147;
                double scoreLong=userFavorStockLong.getOrDefault(stock, 0.0);
                double scoreLongNormal= scoreLong>0 ? Math.log(1+value) : 0;
                double favorStockScore=getStockFavorScore(scoreLongNormal, scoreShortNormal, 1.0, 3.0);
                stockScore.put(stock, favorStockScore);
            });
        }else{
            return userFavorStockLong.entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .limit(limit)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        return  stockScore.entrySet().stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .limit(limit)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
        }

}

