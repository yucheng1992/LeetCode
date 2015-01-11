/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preorder(root, 0);
        return sum;
    }
    public void preorder(TreeNode node, int num) {
        if (node.left == null && node.right == null) {
            sum += num * 10 + node.val;
            return;
            }
        if (node.left != null) {
            preorder(node.left, num * 10 + node.val);
        }
        if (node.right != null) {
            preorder(node.right, num * 10 + node.val);
        }
    }
}
