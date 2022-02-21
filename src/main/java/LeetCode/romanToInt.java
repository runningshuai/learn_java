package LeetCode;

//罗马字符转化成整数
public class romanToInt {
    public int romanToInt(String s){
        if(s ==null){
            return 0;
        }
//        Map<String,Integer> map = new HashMap<>();
//        map.put("I", 1);
//        map.put("V", 5);
//        map.put("X", 10);
//        map.put("L", 50);
//        map.put("C", 100);
//        map.put("D", 500);
//        map.put("M", 1000);
//        map.put("IV", 4);
//        map.put("IX", 9);
//        map.put("XL", 40);
//        map.put("XC", 90);
//        map.put("CD", 400);
//        map.put("CM", 900);
        int pop;
        int temp=0;
//        for(int i=0; i<=s.length()-1;){
//            if ( i < s.length() - 1 && map.containsKey(s.substring(i, i+2))){
//                pop = map.get(s.substring(i, i+2));
//                i = i+2;
//            }else{
//                pop = map.get(s.substring(i, i+1));
//                i += 1;
//            }
//            temp = temp + pop;
//        }

        for(int j=0; j<=s.length()-1;){
            if ( j < s.length() - 1 && (pop=getValue(s.substring(j, j+2))) > 0){
                j = j+2;
            }else{
                pop = getValue(s.substring(j, j+1));
                j += 1;
            }
            temp = temp + pop;
        }
        return temp;
    }
    //case 比hashmap快
    public int getValue(String s) {
        switch (s) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        romanToInt roman = new romanToInt();
        int result = roman.romanToInt("MCMXCIV");
        System.out.println(result);
    }
}
