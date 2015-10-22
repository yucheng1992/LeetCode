public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        return calDistance(x) + calDistance(y);
    }
    
    private int calDistance(List<Integer> list) {
        Collections.sort(list);
        int l = 0, r = list.size() - 1;
        int res = 0;
        while (l < r) {
            res += list.get(r) - list.get(l);
            l++;
            r--;
        }
        return res;
    }
}
