public class NumberOfIslands {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    dfs(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }
    
    public void dfs(boolean[][] grid, int row, int col) {
        grid[row][col] = false;
        if (row - 1 >= 0 && grid[row-1][col]) {
            dfs(grid, row - 1, col);
        }
        if (row + 1 < grid.length && grid[row+1][col]) {
            dfs(grid, row + 1, col);
        }
        if (col - 1 >= 0 && grid[row][col-1]) {
            dfs(grid, row, col - 1);
        }
        if (col + 1 < grid[0].length && grid[row][col+1]) {
            dfs(grid, row, col + 1);
        }
    }
}

