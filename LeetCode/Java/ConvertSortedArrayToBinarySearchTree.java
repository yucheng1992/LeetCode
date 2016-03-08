/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedArrayToBinarySearchTree  {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return helper(num, 0, num.length-1);
    }
    public TreeNode helper(int[] num, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            TreeNode leaf = new TreeNode(num[l]);
            return leaf;
        }
        int m = (l + r) / 2;
        TreeNode node = new TreeNode(num[m]);
        node.left = helper(num, l, m-1);
        node.right = helper(num, m+1, r);
        return node;
    }
}
