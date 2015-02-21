/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.*;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, root);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode neighbour = queue.poll();
            for (UndirectedGraphNode n: neighbour.neighbors) {
                if (!map.containsKey(n)) {
                    queue.add(n);
                    UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                    map.put(n, newNode);
                }
                map.get(neighbour).neighbors.add(map.get(n));
            }
        }
        return root;
    }
}
