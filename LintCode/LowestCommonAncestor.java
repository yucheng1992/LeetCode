/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode res = null;
        
        List<TreeNode> path1 = new LinkedList<TreeNode>();
        List<TreeNode> path2 = new LinkedList<TreeNode>();
        
        if (!findPath(root, path1, A) || !findPath(root, path2, B)) {
            return res;
        }
        
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i).equals(path2.get(i))) {
                res = path1.get(i);
            } else {
                break;
            }
        }
        return res;
    }
    
    public boolean findPath(TreeNode node, List<TreeNode> path, TreeNode target) {
        if (node == null) {
            return false;
        }
        
        path.add(node);
        
        if (node.equals(target)) {
            return true;
        }
        
        if ((node.left != null && findPath(node.left, path, target)) || (node.right != null && findPath(node.right, path, target))) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}

