/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int val = root.val;
        TreeNode node = root;
        while (node != null) {
            if (Math.abs(node.val - target) < diff) {
                diff = Math.abs(node.val - target);
                val = node.val;
            }
            if ((double)node.val == target) {
                break;
            } else if ((double)node.val < target) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return val;
    }
}
