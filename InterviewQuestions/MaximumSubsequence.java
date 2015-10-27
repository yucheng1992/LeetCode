public class MaximumSubsequence {
    public int getMaximum(String a, String b) {
        int l = 1;
        int r = b.length() / a.length();
        while (l <= r) {
            int m = (l + r) / 2;
            if (isValid(a, b, m)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    private boolean isValid(String a, String b, int k) {
        int index = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < k; j++) {
                while (index < b.length() && b.charAt(index) != a.charAt(i)) {
                    index++;
                }
                if (index == b.length()) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }
}
