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
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        ListNode fast = head.next;
        while (prev != null) {
            while (fast != null &&fast.val == prev.val) {
                fast = fast.next;
            }
            prev.next = fast;
            prev = prev.next;
        }
        return dummy.next;
    }
}
