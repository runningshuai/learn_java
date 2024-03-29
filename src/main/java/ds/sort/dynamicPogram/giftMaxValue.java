package ds.sort.dynamicPogram;

/**
 * 一个m\times nm×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class giftMaxValue {
    public static int maxValue (int[][] grid) {
        // write code here
        for(int i=1; i< grid.length;i++){
            grid[i][0] += grid[i-1][0];
        }

        for(int j=1; j<grid[0].length; j++){
            grid[0][j] += grid[0][j-1];
        }

        for(int i=1; i<grid.length;i++){
            for(int j=1; j<grid[0].length;j++){
                grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }

    public static int[][] maxValuePrint (int[][] grid) {
        // write code here
        for(int i=1; i< grid.length;i++){
            grid[i][0] += grid[i-1][0];
        }

        for(int j=1; j<grid[0].length; j++){
            grid[0][j] += grid[0][j-1];
        }

        for(int i=1; i<grid.length;i++){
            for(int j=1; j<grid[0].length;j++){
                grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
//        for(int i=1; i< grid.length;i++){
//            grid[i][0] += grid[i-1][0];
//        }
//
//        for(int j=1; j<grid[0].length; j++){
//            grid[0][j] += grid[0][j-1];
//        }

        grid = maxValuePrint(grid);

        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxValue(grid));
    }


}
