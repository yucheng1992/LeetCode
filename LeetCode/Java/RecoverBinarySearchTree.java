/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBinarySearchTree {
    TreeNode prev = null;
    TreeNode s1 = null;
    TreeNode s2 = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = s1.val;
        s1.val = s2.val;
        s2.val = temp;
    }
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != null && prev.val > root.val) {
            if (s1 == null) {
                s1 = prev;
                s2 = root;
            } else {
                s2 = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}
