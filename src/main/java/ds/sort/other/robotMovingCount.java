package ds.sort.other;

/**
 * 地上有一个 rows 行和 cols 列的方格。坐标从 [0,0] 到 [rows-1,cols-1] 。
 * 一个机器人从坐标 [0,0] 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于 threshold 的格子。
 * 例如，当 threshold 为 18 时，机器人能够进入方格   [35,37] ，
 * 因为 3+5+3+7 = 18。但是，它不能进入方格 [35,38] ，因为 3+5+3+8 = 19 。
 * 请问该机器人能够达到多少个格子？
 */
public class robotMovingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return dfs(threshold, rows, cols, 0, 0, visited);

    }

    public static int dfs(int threshold, int rows, int cols, int i, int j, boolean[][] visited){
        System.out.print(i);
        System.out.print(j);
        System.out.print(rows);
        System.out.print(cols);
        System.out.println(i>=rows);
        if(i<0 || i>=rows || j<0 || j>=cols || cal(i)+cal(j) > threshold || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return 1+dfs(threshold, rows, cols, i+1, j, visited) +
                dfs(threshold, rows, cols, i-1, j, visited) +
                dfs(threshold, rows, cols, i, j+1, visited) +
                dfs(threshold, rows, cols, i, j-1, visited);
    }

    public static int cal(int a){
        int sum = 0;
        while(a>0){
            sum +=a%10;
            a /=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int count = movingCount(1,2,3);
        System.out.println(count);
    }

}
