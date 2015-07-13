/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (containsNode(root.left, p) && containsNode(root.left, q)) {
                root = root.left;
            } else if (containsNode(root.right, p) && containsNode(root.right, q)) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
    
    public boolean containsNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        } else if (root.equals(node)) {
            return true;
        } else {
            return containsNode(root.left, node) || containsNode(root.right, node);
        }
    }
}
