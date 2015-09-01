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
public class SegmentTreeBuildII {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        SegmentTreeNode root = helper(A, 0, A.length - 1);
        return root;
    }
    
    public SegmentTreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, A[i]);
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, max);
        SegmentTreeNode left = helper(A, start, (start + end) / 2);
        SegmentTreeNode right = helper(A, (start + end) / 2 + 1, end);
        node.left = left;
        node.right = right;
        return node;
    }
}
