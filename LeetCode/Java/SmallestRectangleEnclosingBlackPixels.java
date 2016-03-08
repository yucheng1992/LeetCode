public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int[] res = new int[]{image.length, -1, image[0].length, -1};
        dfs(image, x, y, res);
        return (res[1] - res[0] + 1) * (res[3] - res[2] + 1);
    }
    
    private void dfs(char[][] image, int x, int y, int[] res) { 
        if (x < 0 || x >= image.length|| y < 0 || y >= image[0].length || image[x][y] == '2' || image[x][y] == '0') {
            return;
        }
        image[x][y] = '2';
        if (x < res[0]) {
            res[0] = x;
        }
        if (x > res[1]) {
            res[1] = x;
        }
        if (y < res[2]) {
            res[2] = y;
        }
        if (y > res[3]) {
            res[3] = y;
        }
        dfs(image, x - 1, y, res);
        dfs(image, x + 1, y, res);
        dfs(image, x, y - 1, res);
        dfs(image, x, y + 1, res);
    }
}
