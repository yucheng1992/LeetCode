public class CoinsInALineII {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int val1 = 0, val2 = 0;
        boolean turn = true;
        for (int i = 0; i < values.length;) {
            if (turn) {
                val1 += values[i++];
                if (i < values.length && (i + 1 == values.length || values[i] >= values[i+1])) {
                    val1 += values[i++];
                }
            } else {
                val2 += values[i++];
                if (i < values.length && (i + 1 == values.length || values[i] >= values[i+1])) {
                    val2 += values[i++];
                }
            }
            turn = !turn;
        }
        return val1 > val2;
