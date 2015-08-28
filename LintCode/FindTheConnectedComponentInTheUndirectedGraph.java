/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class FindTheConnectedComponentInTheUndirectedGraph {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return res;
        }
        Set<UndirectedGraphNode> cache = new HashSet<UndirectedGraphNode>();
        for (int i = 0; i < nodes.size(); i++) {
            if (!cache.contains(nodes.get(i))) {
                List<Integer> cur = new ArrayList<Integer>();
                Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                queue.add(nodes.get(i));
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        UndirectedGraphNode node = queue.poll();
                        if (!cache.contains(node)) {
                            cur.add(node.label);
                            cache.add(node);
                            for (UndirectedGraphNode neighbor: node.neighbors) {
                                queue.add(neighbor);
                            }
                        }
                        
                    }
                }
                Collections.sort(cur);
                res.add(cur);
            }
        }
        return res;
    }
}
