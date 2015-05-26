public class TriangleCount {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(S);
        for (int i = 0; i < S.length - 2; i++) {
            for (int j = i + 1; j < S.length - 1; j++) {
                for (int k = j + 1; k < S.length; k++) {
                    if (S[i] + S[j] > S[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
