public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int k = 1;
        while (left < right && top < bottom) {
            for (int j = left; j < right; j++) {
                matrix[top][j] = k++;
            }
            for (int i = top; i < bottom; i++) {
                matrix[i][right] = k++;
            }
            for (int j = right; j > left; j--) {
                matrix[bottom][j] = k++;
            }
            for (int i = bottom; i > top; i--) {
                matrix[i][left] = k++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (n % 2 != 0) {
            matrix[n/2][n/2] = n * n;
        }
        return matrix;
    }
}
