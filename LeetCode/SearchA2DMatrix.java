public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //search the row number first
        int l = 0;
        int r = matrix.length-1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[m][0] == target) {
                return true;
            } else if (matrix[m][0] < target){
                l = m + 1;
                m = (l + r) / 2;
            } else {
                r = m - 1;
                m = (l + r) / 2;
            }
        }
        int index = l - 1;
        if (index < 0 || index >= matrix.length) {
            return false;
        }
        //search the target row for the target number
        l = 0;
        r = matrix[0].length - 1;
        while (l <=r) {
            int m = (l + r) / 2;
            if (matrix[index][m] == target) {
                return true;
            } else if (matrix[index][m] < target) {
                l = m + 1;
                m = (l + r) / 2;
            } else {
                r = m - 1;
                m = (l + r) / 2;
            }
        }
        return false;
    }
}
