/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<Integer>();
        helper(root, 0, sum, cur);
        return res;
    }
    public void helper(TreeNode node, int num, int sum, List<Integer> cur) {
        if (node.left == null && node.right == null) {
            if (num + node.val == sum) {
                cur.add(node.val);
                res.add(cur);
            }
            return;
        }
        if (node.left != null) {
            List<Integer> path = new ArrayList<Integer>();
            path.addAll(cur);
            path.add(node.val);
            helper(node.left, num + node.val, sum, path);
        }
        if (node.right != null) {
            List<Integer> path = new ArrayList<Integer>();
            path.addAll(cur);
            path.add(node.val);
            helper(node.right, num + node.val, sum, path);
        }
    }
}
