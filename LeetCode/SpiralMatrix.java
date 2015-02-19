import java.util.*;


public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int levelNum = Math.min(matrix[0].length, matrix.length) / 2;
        for (int level = 0; level < levelNum; level++) {
            for (int j = level; j < matrix[0].length - level - 1; j++) {
                res.add(matrix[level][j]);
            }
            for (int i = level; i < matrix.length - level - 1; i++) {
                res.add(matrix[i][matrix[0].length - level - 1]);
            }
            for (int j = matrix[0].length - level - 1; j > level; j--) {
                res.add(matrix[matrix.length - level - 1][j]);
            }
            for (int i = matrix.length - level - 1; i > level; i--) {
                res.add(matrix[i][level]);
            }
        }
        if (Math.min(matrix[0].length, matrix.length) % 2 == 1) {
            if (matrix.length < matrix[0].length) {
                for (int i = levelNum; i < matrix[0].length - levelNum; i++) {
                    res.add(matrix[levelNum][i]);
                }
            } else {
                for (int i = levelNum; i < matrix.length - levelNum; i++) {
                    res.add(matrix[i][levelNum]);
                }
            }
        }
        return res;
    }
}
