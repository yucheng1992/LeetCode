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
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 1;
        double ratio = 0.0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int localMax = 1;
            int numSamePoints = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    numSamePoints++;
                    continue;
                } else if (points[j].x == points[i].x) {
                    ratio = (double)Integer.MAX_VALUE;
                } else if (points[j].y == points[i].y) {
                    ratio = 0.0;
                } else {
                    ratio = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                }
                if (map.containsKey(ratio)) {
                    map.put(ratio, (int)map.get(ratio) + 1);
                } else {
                    map.put(ratio, 2);
                }
            }
            for (Integer val: map.values()) {
                localMax = Math.max(localMax, val);
            }
            localMax += numSamePoints;
            max = Math.max(localMax, max);
        }
        return max;
    }
}
