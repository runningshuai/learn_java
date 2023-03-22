package algorithm.backTrack;

/**
 * @Description: 岛屿的最大面积，递归函数需要有返回值
 * @Author: bsy
 * @Date: 2023/1/5 0:12
 */
public class MaxAreaOfIsLands {
    public int maxAreaOfIsland(int[][] grid) {

        int m=grid.length;
        int n = grid[0].length;
        int res = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;

    }

    int dfs(int[][] grid, int i, int j){
        //只判断当前这一步的面积
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        //标记完之后，其他不会再走
        grid[i][j] = 0;
        return dfs(grid, i, j-1) + dfs(grid, i, j+1) + dfs(grid, i-1, j) + dfs(grid, i+1, j) + 1;
    }
}
