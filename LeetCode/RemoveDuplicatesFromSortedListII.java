/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != null) {
            while (fast != null && fast.val == slow.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                prev.next = slow;
                prev = prev.next;
                slow = fast;
                if (slow != null) {
                    fast = slow.next;
                }
            } else {
                prev.next = fast;
                slow = fast;
                if (slow != null) {
                    fast = slow.next;
                }
            }
        }
        return dummy.next;
    }
}
