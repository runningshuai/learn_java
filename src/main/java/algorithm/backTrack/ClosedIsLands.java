package algorithm.backTrack;

/**
 * @Description: 封闭的岛屿，把四周的岛屿去掉就行了， 0是陆地， 1是海洋
 * @Author: bsy
 * @Date: 2023/1/4 23:55
 */
public class ClosedIsLands {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        //把四周的给淹没
        for(int i=0; i<m; i++){
            dfs(grid, i, 0);
            //注意是列数
            dfs(grid, i, n-1);
        }
        for(int j=0; j<n;j++){
            dfs(grid, 0, j);
            //注意是行数
            dfs(grid, m-1, j);
        }

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    res +=1;
                    dfs(grid, i, j);
                }
            }
        }
        return res;

    }
    //只淹没，不需要返回值
    void dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }

        if(grid[i][j] == 1){
            return;
        }

        grid[i][j] = 1;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
