public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || gird.length < 1) return 0;
        
        int[][] value = new int[grid.length][gird[0].length];
        
        for(int i = 0; i < grid[0].length; i++){
            if(i == 0)
                value[0][i] = grid[0][i]；
            else
                value[0][i] = grid[0][j - 1] + grid[0][j];
        }
        
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(j == 0)
                    value[i][j] = value[i][j] + grid[i - 1][j];
                else
                    value[i][j] = grid[i][j] + Math.min(value[i - 1][j], value[i][j - 1]);
            }
        }
        return value[grid.length - 1][grid[0].length - 1];
    }
}
