/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<List<Integer>> resReverse = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int preSize = 1;
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<Integer>();
            int curSize = 0;
            for (int i = 0; i < preSize; i++) {
                TreeNode node = queue.poll();
                cur.add(node.val);
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
        }
        for (int i = 0; i < res.size(); i++) {
            resReverse.add(res.get(res.size()-1-i));
        }
        return resReverse;
    }
}
