/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class RouteBetweenTwoNodesInGraph {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (s.equals(t)) {
            return true;
        }
        Queue<DirectedGraphNode> path = new LinkedList<DirectedGraphNode>();
        path.add(s);
        while (!path.isEmpty()) {
            DirectedGraphNode cur = path.poll();
            for (DirectedGraphNode node: cur.neighbors) {
                if (node.equals(t)) {
                    return true;
                } else {
                    path.add(node);
                }
            }
        }
        return false;
    }
}
