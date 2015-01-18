public class ZigzagConversion {
    public String convert(String s, int nRows) {
        if (s.length() <= 1 || s == null || nRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int set = (s.length() - 1) / (2 * nRows - 2) + 1;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < set; j++) {
                if (i == 0 || i == nRows - 1) {
                    if (j * (2 * nRows - 2) + i < s.length()) {
                        res.append(s.charAt(j * (2 * nRows - 2) + i)); 
                    }
                } else {
                    if (j * (2 * nRows - 2) + i < s.length()) {
                        res.append(s.charAt(j * (2 * nRows - 2) + i));
                    }
                    if ((j + 1) * (2 * nRows - 2) - i < s.length()) {
                        res.append(s.charAt((j + 1) * (2 * nRows - 2) - i));
                    }
                }
            }
        }
        return res.toString();
    }
}
