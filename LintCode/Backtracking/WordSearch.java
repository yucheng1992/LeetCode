public class WordSearch {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        boolean[][] grid = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, grid, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, boolean[][] grid, String word, int index, int row, int col) {
        if (board[row][col] != word.charAt(index) || grid[row][col]) {
            return false;
        }
        if (index >= word.length() - 1) {
            return true;
        }
        grid[row][col] = true;
        if (row - 1 >= 0 && helper(board, grid, word, index + 1, row - 1, col)) {
            return true;
        }
        if (row + 1 < board.length && helper(board, grid, word, index + 1, row + 1, col)) {
            return true;
        }
        if (col - 1 >= 0 && helper(board, grid, word, index + 1, row, col - 1)) {
            return true;
        }
        if (col + 1 < board[0].length && helper(board, grid, word, index + 1, row, col + 1)) {
            return true;
        }
        grid[row][col] = false;
        return false;
    }
}
