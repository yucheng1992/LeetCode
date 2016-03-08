/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[]{1};
        helper(root.val, root.left, 1, res);
        helper(root.val, root.right, 1, res);
        return res[0];
    }
    
    private void helper(int prev, TreeNode node, int len, int[] res) {
        if (len > res[0]) {
            res[0] = len;
        }
        if (node == null) {
            return;
        }
        helper(node.val, node.left, node.val == prev + 1 ? len + 1 : 1, res);
        helper(node.val, node.right, node.val == prev + 1 ? len + 1 : 1, res);
    }
}
