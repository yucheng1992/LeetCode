/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    boolean hasPath = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        preorder(root, 0, sum);
        return hasPath;
    }
    public void preorder(TreeNode node, int num, int sum) {
        if (node.left == null && node.right == null) {
            if (num + node.val == sum) {
                hasPath = true;
            }
            return;
        }
        if (node.left != null) {
            preorder(node.left, num + node.val, sum);
        }
        if (node.right != null) {
            preorder(node.right, num + node.val, sum);
        }
    }
}
