/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (k <= count(root.left)) {
            return kthSmallest(root.left, k);
        } else if (k > count(root.left) + 1) {
            return kthSmallest(root.right, k - count(root.left) - 1);
        }
        return root.val;
    }
    
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}
