/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SegmentTreeQueryII {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += helper(root, i);
        }
        return count;
    }
    
    public int helper(SegmentTreeNode root, int target) {
        if (root == null || target > root.end || target < root.start) {
            return 0;
        }
        if (root.end == root.start) {
            if (root.end == target) {
                return root.count;
            } else {
                return 0;
            }
        }
        if (target > (root.start + root.end) / 2) {
            return helper(root.right, target);
        } else {
            return helper(root.left, target);
        }
    }
}
