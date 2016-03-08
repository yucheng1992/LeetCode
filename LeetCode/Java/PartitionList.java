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
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        ListNode walker = dummy;
        while (runner.next != null) {
            if (runner.next.val < x) {
                if (walker != runner) {
                    ListNode next = runner.next.next;
                    runner.next.next = walker.next;
                    walker.next = runner.next;
                    runner.next = next;
                } else {
                    runner = runner.next;
                }
                walker = walker.next;
            } else {
                runner = runner.next;
            }
        }
        return dummy.next;
    }
}
