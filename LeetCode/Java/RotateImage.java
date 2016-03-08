public class RotateImage {
    public void rotate(int[][] matrix) {
        //rotate the matrix according to the diagonal line
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-j][matrix.length-1-i];
                matrix[matrix.length-1-j][matrix.length-1-i] = temp;
            }
        }
        //turnover the matrix 
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-i-1][j];
                matrix[matrix.length-i-1][j] = temp;
            }
        }
    }
}
