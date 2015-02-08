public class MaximumGap {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
            if (num[i] < min) {
                min = num[i];
            }
        }
        int gap = Math.max(1, (max - min - 1) / (num.length - 1) + 1);
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        for (int i = 0; i < num.length; i++) {
            int k = (num[i] - min) / gap + 1;
            if (!map.containsKey(k)) {
                int[] minMax = {num[i], num[i]};
                map.put(k, minMax);
            } else {
                if (num[i] < map.get(k)[0]) {
                    int[] minMax = {num[i], map.get(k)[1]};
                    map.put(k, minMax);
                }
                if (num[i] > map.get(k)[1]) {
                    int[] minMax = {map.get(k)[0], num[i]};
                    map.put(k, minMax);
                }
            }
        }
        int maxGap = Integer.MIN_VALUE;
        for (int i = 1; i <= num.length; i++) {
            if (map.containsKey(i)) {
                for (int j = i + 1; j <= num.length; j++) {
                    if (map.containsKey(j)) {
                        if (map.get(j)[0] - map.get(i)[1] > maxGap) {
                            maxGap = map.get(j)[0] - map.get(i)[1]; 
                        }
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        return maxGap;
    }
}
