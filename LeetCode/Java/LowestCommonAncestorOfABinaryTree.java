/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (p == q) {
            return p;
        }
        boolean pInLeft = containsNode(root.left, p);
        boolean qInLeft = containsNode(root.left, q);
        if (pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (!pInLeft && !qInLeft) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
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
