/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int[] count = new int[]{0};
        isUnivalSubtrees(root, count);
        return count[0];
    }
    
    public boolean isUnivalSubtrees(TreeNode node, int[] count) {
        if (node.left == null && node.right == null) {
            count[0] += 1;
            return true;
        } else if (node.left != null && node.right == null) {
            if (isUnivalSubtrees(node.left, count) && node.val == node.left.val) {
                count[0] += 1;
                return true;
            } else {
                return false;
            }
        } else if (node.right != null && node.left == null) {
            if (isUnivalSubtrees(node.right, count) && node.val == node.right.val) {
                count[0] += 1;
                return true;
            } else {
                return false;
            }
        } else {
            boolean left = isUnivalSubtrees(node.left, count);
            boolean right = isUnivalSubtrees(node.right, count);
            if (left && right && node.val == node.left.val && node.val == node.right.val) {
                count[0] += 1;
                return true;
            } else {
                return false;
            }
        }
    }
}
