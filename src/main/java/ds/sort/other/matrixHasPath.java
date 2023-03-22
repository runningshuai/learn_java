package ds.sort.other;

/**
 * 请设计一个函数，用来判断在一个n乘m的矩阵中是否存在一条包含某长度为len的字符串所有字符的路径
 * 复杂度：m*n*(k^3)
 */
public class matrixHasPath {
    public static boolean hasPath (char[][] matrix, String word) {
        // write code here
        for(int i=0; i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //只返回正确的，错误的继续遍历
                if(judge(matrix, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public static boolean judge(char[][] matrix, String word, int i, int j, int index){
        //需要先判断是否匹配
        if(i<0||i>=matrix.length ||j<0||j>=matrix[0].length||matrix[i][j] != word.charAt(index)){
            return false;
        }
        if(index==word.length()-1) return true;
        System.out.println(word.charAt(index));

        //到这一步代表匹配的上
        Character tmp = matrix[i][j];
        // 给一个特殊的字符，以后不再匹配
        matrix[i][j] = '#';
        boolean res = judge(matrix, word, i+1, j, index+1)
                || judge(matrix, word, i-1, j, index+1)
                || judge(matrix, word, i, j+1, index+1)
                || judge(matrix, word, i, j-1, index+1);
        matrix[i][j] = tmp;
        return res;

    }

    public static void main(String[] args) {
//        char[][] matrix = new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
//        String word = "see";
        char[][] matrix = new char[][]{{'A'}};
        String word = "B";
        System.out.println(hasPath(matrix, word));
    }
}
