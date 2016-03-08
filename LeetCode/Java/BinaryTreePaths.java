/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    List<String> res = new LinkedList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return res;
    }
    
    public void helper(TreeNode node, String cur) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(cur + node.val);
        }
        if (node.left != null) {
            helper(node.left, cur + node.val + "->");
        }
        if (node.right != null) {
            helper(node.right, cur + node.val + "->");
        }
    }
}
