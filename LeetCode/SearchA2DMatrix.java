public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;
        int l = 0;
        int r = width * height - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int row = m / width;
            int col = m % width;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
