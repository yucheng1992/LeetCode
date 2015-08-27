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
public class BinaryTreeMaximumPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        int[] res = new int[]{Integer.MIN_VALUE};
        helper(root, res);
        return res[0];
    }
    
    public int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res[0] = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
