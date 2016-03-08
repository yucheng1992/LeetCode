import java.util.*;


public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        char[][] cur = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cur[i][j] = '.';
            }
        }
        dfs(res, cur, 0, n);
        return res;
    }

    public void dfs(List<String[]> res, char[][] cur, int row, int n) {
        for (int i = 0; i < n; i++) {
            cur[row][i] = 'Q';
            if (valid(cur, row, i)) {
                if (row == n-1) {
                    String[] str = new String[n];
                    for (int k = 0; k < n; k++) {
                        str[k] = String.valueOf(cur[k]);
                    }
                    res.add(str);
                    cur[row][i] = '.';
                    continue;
                }
                dfs(res, cur, row+1, n);
            }
            cur[row][i] = '.';
        }
    }
            
    public boolean valid(char[][] cur, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (cur[k][j] == 'Q') {
                return false;
            }
        }
        for (int k = 0; k < j; k++) {
            if (cur[i][k] == 'Q') {
                return false;
            }
        }
        for (int k = i - 1, m = j - 1; k >= 0 && m >= 0; k--, m--) {
            if (cur[k][m] == 'Q') {
                return false;
            }
        }
        for (int k = i - 1, m = j + 1; k >= 0 && m < cur.length; k--, m++) {
            if (cur[k][m] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // A new version of DFS
    List<String[]> res = new ArrayList<String[]>();
    public List<String[]> solveNQueens2(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        String[] cur = new String[n];
        dfs2(board, 0, n, cur);
        return res;
    }
    
    public void dfs2(char[][] board, int row, int n, String[] cur) {
        if (row >= n) {
            String[] newCur = new String[n];
            for (int j = 0; j < n; j++) {
                newCur[j] = cur[j];
            }
            res.add(newCur);
            return;
        }
        for (int i = 0; i < n; i++) {
            board[row][i] = 'Q';
            if (isValid2(board, row, i)) {
                cur[row] = String.valueOf(board[row]);
                dfs2(board, row + 1, n, cur);
            }
            board[row][i] = '.';
        }
    }
    
    public boolean isValid2(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
