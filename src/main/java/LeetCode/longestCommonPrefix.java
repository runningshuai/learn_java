package LeetCode;

//横向扫描：每两个进行匹配，然后匹配结果和下一个进行匹配
//时间复杂度：O(mn)O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量
public class longestCommonPrefix {

    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];
        for (int i=0; i< strs.length; i++){
            prefix = longestCommonPrefix(prefix, strs[i]);
            //前几个没有公共字符串，提前结束
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    //两个字符串的比较
    public String longestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length){
            if (str1.charAt(index)==str2.charAt(index)){
                index++;
            }else{
                break;
            }
        }
        return str1.substring(0, index);
    }
}
