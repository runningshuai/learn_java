package algorithm.string;

/**
 * @Description: 单词搜索
 * @Author: bsy
 * @Date: 2023/2/25 1:14
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.length() <= 0){return false;}
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(traverse(board,visited, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean traverse(char[][] board, int[][] visited, int i, int j,  String word, int index){

        if( i<0 || i>=board.length || j<0 || j>=board[0].length || index >= word.length()|| board[i][j] != word.charAt(index)){

            return false;
        }
        if(visited[i][j]==1){return false;}
        if(board[i][j] == word.charAt(index) && index == word.length() - 1 ){return true;}

        visited[i][j] = 1;
        for(int[] direction: new int[][]{{-1, 0}, {1, 0}, {0,1}, {0, -1}}){
            if(traverse(board, visited, i + direction[0], j + direction[1], word, index + 1)){return true;}
        }
        visited[i][j] = 0;
        return false;

    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][]{{'a', 'b', 'c', 'e'},{'s', 'f', 'c', 's'},{'a', 'd', 'e', 'e'}};
        boolean res = wordSearch.exist(board, "abcced");
        System.out.println(res);
    }
}