public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> height = new LinkedList<int[]>();
        List<int[]> res = new LinkedList<int[]>();
        if (buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        for (int i = 0; i < buildings.length; i++) {
            height.add(new int[]{buildings[i][0], -buildings[i][2]});
            height.add(new int[]{buildings[i][1], buildings[i][2]});
        }
        Collections.sort(height, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[]b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(height.size(), new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        pq.add(0);
        int prev = 0;
        for (int[] h: height) {
            if (h[1] < 0) {
                pq.add(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (cur != prev) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}
