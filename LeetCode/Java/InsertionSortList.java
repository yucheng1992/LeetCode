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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            prev = dummy;
            while (prev.next != null && prev.next.val <= cur.val) {
                prev = prev.next;
            }
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
