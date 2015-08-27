/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class NumberOfIslands {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        for (Point point: operators) {
            int p = point.x * m + point.y;
            int pfa = find(map, p);
            if (pfa == p) {
                count += 1;
            }
            for (int i = 0; i < 4; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                    continue;
                }
                int q = (point.x + dx[i]) * m + point.y + dy[i];
                if (map.containsKey(q)) {
                    int qfa = find(map, q);
                    if (qfa != pfa) {
                        count -= 1;
                        map.put(qfa, pfa);
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    
    private int find(Map<Integer, Integer> map, int point) {
        if (!map.containsKey(point)) {
            map.put(point, point);
            return point;
        }
        while (map.get(point) != point) {
            point = map.get(point);
        }
        return point;
    }
}
