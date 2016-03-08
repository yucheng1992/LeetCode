public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.insert(0, Character.toChars((n-1) % 26 + 'A'));
            n = n / 26;
            if (res.charAt(0) == 'Z') n = n - 1;
        }
        return res.toString();
    }
}
