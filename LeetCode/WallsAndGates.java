public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    if (i - 1 >= 0 && rooms[i - 1][j] > 1) {
                        dfs(rooms, i - 1, j, 1);
                    }
                    if (i + 1 < rooms.length && rooms[i + 1][j] > 1) {
                        dfs(rooms, i + 1, j, 1);
                    }
                    if (j - 1 >= 0 && rooms[i][j - 1] > 1) {
                        dfs(rooms, i, j - 1, 1);
                    }
                    if (j + 1 < rooms[0].length && rooms[i][j + 1] > 1) {
                        dfs(rooms, i, j + 1, 1);
                    }
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, int row, int col, int level) {
        if (rooms[row][col] == -1 || rooms[row][col] == 0 || rooms[row][col] < level) {
            return;
        }
        rooms[row][col] = level;
        if (row - 1 >= 0) {
            dfs(rooms, row - 1, col, level + 1);
        }
        if (col - 1 >= 0) {
            dfs(rooms, row, col - 1, level + 1);
        }
        if (row + 1 < rooms.length) {
            dfs(rooms, row + 1, col, level + 1);
        }
        if (col + 1 < rooms[0].length) {
            dfs(rooms, row, col + 1, level + 1);
        }
    }
}
