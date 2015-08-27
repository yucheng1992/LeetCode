/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsOnALine {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        int max = 0;
        if (points == null || points.length == 0) {
            return max;
        }
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> cache = new HashMap<Double, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                if (points[j].x == points[i].x) {
                    if (cache.containsKey(Double.MAX_VALUE)) {
                        cache.put(Double.MAX_VALUE, cache.get(Double.MAX_VALUE) + 1);
                    } else {
                        cache.put(Double.MAX_VALUE, 1);
                    }
                } else {
                    double slope = (points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if (cache.containsKey(slope)) {
                        cache.put(slope, cache.get(slope) + 1);
                    } else {
                        cache.put(slope, 1);
                    }
                }
            }
            int curMax = 0;
            for (Double key: cache.keySet()) {
                curMax = Math.max(curMax, cache.get(key));
            }
            max = Math.max(max, curMax + 1);
        }
        return max;
    }
}
