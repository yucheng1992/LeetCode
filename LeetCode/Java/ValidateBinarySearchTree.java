/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public boolean helper(TreeNode node, int max, int min) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }
        if (node.val == Integer.MAX_VALUE && node.right != null) {
            return false;
        }
        if (node.val == Integer.MIN_VALUE && node.left != null) {
            return false;
        }
        return helper(node.left, node.val-1, min) && helper(node.right, max, node.val+1);
    }
}
