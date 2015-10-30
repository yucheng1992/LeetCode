// 一个平面上有很多点Point(x,y), 找到这些点中四个点为顶点组成最大的正方形，返回面积
public class MaximumSquare {
    
    private class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maximumArea(List<Point> points) {
        Map<Integer, Set<Integer>> mapX = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> mapY = new HashMap<Integer, Set<Integer>>();
        for (Point point: points) {
            if (mapX.containsKey(point.x)) {
                mapX.get(point.x).add(point.y);
            } else {
                Set<Integer> set = new TreeSet<Integer>();
                set.add(point.y);
                mapX.put(point.x, set);
            }
            if (mapY.containsKey(point.y)) {
                mapY.get(point.y).add(point.x);
            } else {
                Set<Integer> set = new TreeSet<Integer>();
                set.add(point.x);
                mapY.put(point.y, set);
            }
        }
        int res = 0;
        for (Integer x: mapX.keySet()) {
            if (mapX.get(x).size() > 1) {
                for (Integer y1: mapX.get(x)) {
                    for (Integer y2: mapX.get(x)) {
                        if (y2 > y1) {
                            int side = y2 - y1;
                            if ((mapY.get(y1).contains(x + side) && mapY.get(y2).contains(x + side)) || (mapY.get(y1).contains(x - side) && mapY.get(y2).contains(x - side))) {
                                res = Math.max(res, side * side);            
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
