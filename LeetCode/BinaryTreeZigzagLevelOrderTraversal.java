/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeZigzagLevelOrderTraversal  {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int preSize = 1;
        int index = 0;
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<Integer>();
            int curSize = 0;
            for (int i = 0; i < preSize; i++) {
                TreeNode node = queue.poll();
                if (index % 2 == 0) {
                    cur.add(node.val);
                } else {
                    cur.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                    curSize++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    curSize++;
                }
            }
            res.add(cur);
            preSize = curSize;
            index++;
        }
        return res;
    }
}
