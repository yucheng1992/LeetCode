public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }
    public void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] != 'X') {
            return;
        }
        grid[i][j] = '1';
        if (i > 0) {
            dfs(grid, i - 1, j);
        }
        if (i + 1< grid.length) {
            dfs(grid, i + 1, j);
        }
        if (j > 0) {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length) {
            dfs(grid, i, j + 1);
        }
    }
}
