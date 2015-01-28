public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }
            if (board[board.length-1][i] == 'O') {
                bfs(board, board.length-1, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][board[0].length-1] == 'O') {
                bfs(board, i, board[0].length-1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void bfs(char[][] board, int i, int j) {
        if (board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';
        Queue<Integer> queue = new LinkedList<Integer>();
        int num = i * board[0].length + j;
        queue.offer(num);
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int row = code / board[0].length;
            int col = code % board[0].length;
            if (row - 1 >= 0) {
                if (board[row-1][col] == 'O') {
                    board[row-1][col] = '#';
                    queue.offer((row-1) * board[0].length + col);
                }
            }
            if (row + 1 <= board.length - 1) {
                if (board[row+1][col] == 'O') {
                    board[row+1][col] = '#';
                    queue.offer((row+1) * board[0].length + col);
                }
            }
            if (col - 1 >= 0) {
                if (board[row][col-1] == 'O') {
                    board[row][col-1] = '#';
                    queue.offer(row * board[0].length + col - 1);
                }
            }
            if (col + 1 <= board[0].length - 1) {
                if (board[row][col+1] == 'O') {
                    board[row][col+1] = '#';
                    queue.offer(row * board[0].length + col + 1);
                }
            }    
        }
    }
}
