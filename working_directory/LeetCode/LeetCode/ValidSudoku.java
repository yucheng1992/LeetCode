import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //judge whether each row and each column is valid
        for (int i = 0; i < board.length; i++) {
            Map<Integer, Integer> row = new HashMap<Integer, Integer>();
            Map<Integer, Integer> column = new HashMap<Integer, Integer>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && row.containsKey(Character.getNumericValue(board[i][j])) || board[j][i] != '.' && column.containsKey(Character.getNumericValue(board[j][i]))) {
                    return false;
                } else {
                    row.put(Character.getNumericValue(board[i][j]), 1);
                    column.put(Character.getNumericValue(board[j][i]), 1);
                }
            }
        }
        //judge whether each 3x3 cube is valid
        for (int k = 0; k < 3; k++) {
            for (int m = 0; m < 3; m++) {
                Map<Integer, Integer> cube = new HashMap<Integer, Integer>();
                for (int i = 3*k; i < 3*(k+1); i++) {
                    for (int j = 3*m; j < 3*(m+1); j++) {
                        if (board[i][j] != '.' && cube.containsKey(Character.getNumericValue(board[i][j]))) {
                            return false;
                        } else {
                            cube.put(Character.getNumericValue(board[i][j]), 1);
                        }
                    }
                }
            }
        }
        return true;
    }
}
