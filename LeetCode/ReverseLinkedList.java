/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        if (cur.next == null) {
            return head;
        }
        while (cur != null) {
            ListNode next = cur.next;
            dummy.next = cur;
            cur.next = pre;
            pre.next = next;
            pre = cur;
            cur = next;
        }
        return dummy.next;
    }
}
