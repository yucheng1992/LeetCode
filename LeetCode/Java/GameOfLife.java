public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                if (i - 1 >= 0) {
                    if (board[i - 1][j] == 1 || board[i - 1][j] == -1) {
                        count += 1;
                    }
                    if (j - 1 >= 0) {
                        if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1) {
                            count += 1;
                        }
                    }
                    if (j + 1 < board[0].length) {
                        if (board[i - 1][j  + 1] == 1 || board[i - 1][j  + 1] == -1) {
                            count += 1;
                        }    
                    }
                }
                if (i + 1 < board.length) {
                    if (board[i + 1][j] == 1 || board[i + 1][j] == -1) {
                        count += 1;
                    }
                    if (j - 1 >= 0) {
                        if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1) {
                            count += 1;
                        }
                    }
                    if (j + 1 < board[0].length) {
                        if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1) {
                            count += 1;
                        }
                    }
                }
                if (j - 1 >= 0) {
                    if (board[i][j - 1] == 1 || board[i][j - 1] == -1) {
                        count += 1;
                    }
                }
                if (j + 1 < board[0].length) {
                    if (board[i][j + 1] == 1 || board[i][j + 1] == -1) {
                        count += 1;
                    }
                }
                if (board[i][j] == 1) {
                    if (count != 2 && count != 3) {
                        board[i][j] = -1;
                    }
                }
                if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
