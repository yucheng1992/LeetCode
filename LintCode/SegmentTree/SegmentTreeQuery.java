/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SegmentTreeQuery {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    private int max = Integer.MIN_VALUE;
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        dfs(root, start, end);
        return max;
    }
    public void dfs(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return;
        }
        if (root.end < start || root.start > end) {
            return;
        }
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.max);
        }
        if (root.left != null) {
            dfs(root.left, start, end);
        }
        if (root.right != null) {
            dfs(root.right, start, end);
        }
    }
}
