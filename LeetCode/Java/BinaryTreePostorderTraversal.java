/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            postorderTraversal(root.left);
        }
        if (root.right != null) {
            postorderTraversal(root.right);
        }
        res.add(root.val);
        return res;
    }
}
