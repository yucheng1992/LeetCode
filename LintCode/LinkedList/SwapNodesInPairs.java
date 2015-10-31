/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur.next.next = next;
            prev = prev.next.next;
            if (next == null) {
                break;
            } else {
                cur = next.next;
            }
        }
        return dummy.next;
    }
}
