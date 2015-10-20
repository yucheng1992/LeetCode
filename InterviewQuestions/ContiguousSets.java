public class ContiguousSets {
    public int findContiguousSets(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '2';
        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            dfs(grid, row - 1, col);
        }
        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
            dfs(grid, row + 1, col);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            dfs(grid, row, col - 1);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
            dfs(grid, row, col + 1);
        }
    }
}
