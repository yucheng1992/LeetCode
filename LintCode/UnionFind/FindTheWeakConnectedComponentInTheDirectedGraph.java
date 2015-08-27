/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class FindTheWeakConnectedComponentInTheDirectedGraph {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (DirectedGraphNode node: nodes) {
            for (DirectedGraphNode child: node.neighbors) {
                int fa = find(map, node.label);
                int ch = find(map, child.label);
                map.put(fa, ch);
            }
        }
        Map<Integer, List<Integer>> record = new HashMap<Integer, List<Integer>>();
        for (DirectedGraphNode node: nodes) {
            int fa = find(map, node.label);
            if (!record.containsKey(fa)) {
                record.put(fa, new ArrayList<Integer>());
            }
            record.get(fa).add(node.label);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (Integer key: record.keySet()) {
            res.add(record.get(key));
        }
        return res;
    }
    
    public int find(Map<Integer, Integer> map, int val) {
        if (!map.containsKey(val)) {
            map.put(val, val);
            return val;
        }
        while (map.get(val) != val) {
            val = map.get(val);
        }
        return val;
    }
}
