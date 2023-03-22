package algorithm.backTrack;

/**
 * @Description: 岛屿的数量， '1'是陆地，'0'是海洋，四周是海洋
 * @Author: bsy
 * @Date: 2023/1/4 23:28
 */
public class NumIsLands {
    public int numIsLands(char[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    res +=1;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int i, int j){
        if(i<0||i>grid.length - 1||j<0 || j>grid[0].length - 1){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
