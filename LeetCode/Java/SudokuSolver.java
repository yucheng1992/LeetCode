public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
        
    public boolean dfs(char[][] board, int i, int j) {
        //if reaches the last column, turn to the next row
        if (j >= board.length) {
            return dfs(board, i+1, 0);
        }
        //if we cover all the rows, the dfs is over
        if (i >= board.length) {
            return true;
        }
        //typical dfs process
        if (board[i][j] == '.') {
            for (char m = '1'; m <= '9'; m++) {
                board[i][j] = m;
                if (valid(board, i, j)) {
                    if (dfs(board, i, j+1)) {
                        return true;    
                    }
                }
                //go back to the former condition
                board[i][j] = '.';
            }
        }  else {
            return dfs(board, i, j+1);
        }
        return false;
    }
        
    public boolean valid(char[][] board, int i, int j) {
        //check row and column
        for (int k = 0; k < board.length; k++) {
            if (k != j && board[i][k] == board[i][j]) {
                return false;
            }
            if (k != i && board[k][j] == board[i][j]) {
                return false;
            }
        }
        //check the 3x3 cube
        for (int k = i/3*3; k < (i/3+1)*3; k++) {
            for (int m = j/3*3; m < (j/3+1)*3; m++) {
                if (k != i && m != j && board[k][m] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
