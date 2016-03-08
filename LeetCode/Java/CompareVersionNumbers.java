public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for (; i < v1.length; i++) {
            if (i < v2.length) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                    return 1;
                }
            } else if (Integer.parseInt(v1[i]) != 0) {
                return 1;
            }
        }
        if (i < v2.length) {
            for (int j = i; j < v2.length; j++) {
                if (Integer.parseInt(v2[i]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
