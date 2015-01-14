/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }    
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        ListNode head2 = reverse(half);
        ListNode head1 = head;
        while (head1 != null && head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }
    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
