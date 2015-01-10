public class NQueensII {
    public int num = 0;
    public int totalNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(res, board, n, 0);
        return num;
    }

    public void dfs(List<String[]> res, char[][] board, int n, int col) {
        for (int i=0; i<n; i++) {
            board[i][col] = 'Q';
            if (isValid(board, i, col)) {
                if (col == n-1) {
                    String[] s = new String[n];
                    for (int k=0; k<n; k++) {
                        s[k] = String.valueOf(board[k]);
                    }
                    num++;
                    board[i][col] = '.';
                    continue;
                }
                dfs(res, board, n, col+1);
            }
            board[i][col] = '.';
        }
        return;
    }
            
    public boolean isValid(char[][] board, int row, int col) {
        for (int i=0; i<col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i=row+1, j=col-1; i<board.length && j>=0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
