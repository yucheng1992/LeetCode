/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node = head;
        while (node != null) {
            if (node.val != val) {
                node = node.next;
                pre = pre.next;
            } else {
                pre.next = node.next;
                node = node.next;
            }
        }
        return dummy.next;
    }
}
