public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int k = 1;
        for (int level = 0; level < n / 2; level++) {
            for (int j = level; j < n - level - 1; j++) {
                matrix[level][j] = k;
                k++;
            }
            for (int i = level; i < n - level - 1; i++) {
                matrix[i][n - level - 1] = k;
                k++;
            }
            for (int j = n - level - 1; j > level; j--) {
                matrix[n - level - 1][j] = k;
                k++;
            }
            for (int i = n - level - 1; i > level; i--) {
                matrix[i][level] = k;
                k++;
            }
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = k;
        }
        return matrix;
    }
}
