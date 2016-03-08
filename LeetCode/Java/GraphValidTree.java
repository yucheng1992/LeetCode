public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < edges.length; i++) {
            int fatherX = find(map, edges[i][0]);
            int fatherY = find(map, edges[i][1]);
            if (fatherX == fatherY) {
                return false;
            }
            map.put(fatherX, fatherY);
        }
        return edges.length == n - 1;
    }
    
    public int find(Map<Integer, Integer> map, int node) {
        if (!map.containsKey(node)) {
            map.put(node, node);
            return node;
        }
        while (node != map.get(node)) {
            node = map.get(node);
        }
        return node;
    }
}
