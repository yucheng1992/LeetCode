/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        if (Math.abs(treePath(root.left) - treePath(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }
    public int treePath(TreeNode node) {
        //calculate the path length of a tree
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return 1 + Math.max(treePath(node.left), treePath(node.right));
    }
}
