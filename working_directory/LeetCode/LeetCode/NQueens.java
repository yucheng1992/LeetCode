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
}
