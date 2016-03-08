public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        }
        int sameColors = k;
        int diffColors = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int temp = diffColors;
            diffColors = (diffColors + sameColors) * (k - 1);
            sameColors = temp;
        }
        return diffColors + sameColors;
    }
}
