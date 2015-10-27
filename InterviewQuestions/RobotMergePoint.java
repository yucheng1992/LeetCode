public class RobotMergePoint {
    public int[] bestMergePoint(char[][] board) {
        int[][] dist = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    bfs(dist, board, i * board[0].length + j, new HashSet<Integer>());
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dist[i][j] < min) {
                    min = dist[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{x, y, min}
    }

    private static void bfs(int[][] dist, char[][] board, int pos, Set<Integer> set) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(pos);
        set.add(pos);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.poll();
                int row = curPos / board[0].length;
                int col = curPos % board[0].length;
                dist[row][col] += level;
                if (row - 1 >= 0 && board[row - 1][col] != 'X' && !set.contains((row - 1) * board[0].length + col)) {
                    queue.add((row - 1) * board[0].length + col);
                    set.add((row - 1) * board[0].length + col);
                }
                if (col - 1 >= 0 && board[row][col - 1] != 'X' && !set.contains(row * board[0].length + col - 1)) {
                    queue.add(row * board[0].length + col - 1);
                    set.add(row * board[0].length + col - 1);
                }
                if (row + 1 < board.length && board[row + 1][col] != 'X' && !set.contains((row + 1) * board[0].length + col)) {
                    queue.add((row + 1) * board[0].length + col);
                    set.add((row + 1) * board[0].length + col);
                }
                if (col + 1 < board[0].length && board[row][col + 1] != 'X' && !set.contains(row
                        * board[0].length + col + 1)) {
                    queue.add(row * board[0].length + col + 1);
                    set.add(row * board[0].length + col + 1);
                }

            }
            level += 1;
        }
        int j = 0;
    } 
}
