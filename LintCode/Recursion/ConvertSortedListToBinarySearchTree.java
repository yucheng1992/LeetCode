/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class ConvertSortedListToBinarySearchTree {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        ListNode walker = dummy;
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }
        ListNode newRoot = walker.next;
        walker.next = null;
        TreeNode root = new TreeNode(newRoot.val);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(newRoot.next);
        root.left = left;
        root.right = right;
        return root;
    }
}
