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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null || l2 != null) {
            int value = 0;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            value += carry;
            carry = value / 10;
            ListNode node = new ListNode(value % 10);
            prev.next = node;
            prev = prev.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        return dummy.next;
    }
}
