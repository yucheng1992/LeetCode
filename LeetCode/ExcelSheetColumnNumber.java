class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int len = s.length();
        int count = 0;
        for (int i=0; i<len; i++) {
            count += (s.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
        }
        return count;
    }
}
