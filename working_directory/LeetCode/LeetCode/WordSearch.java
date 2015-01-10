public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, boolean[][] visited, String word, int index, int i, int j) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        //dfs in 4 possibile directions
        if (dfs(board, visited, word, index+1, i+1, j)) {
            return true;
        }
        if (dfs(board, visited, word, index+1, i-1, j)) {
            return true;
        }
        if (dfs(board, visited, word, index+1, i, j+1)) {
            return true;
        }
        if (dfs(board, visited, word, index+1, i, j-1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
