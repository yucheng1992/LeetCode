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
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int add = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + add;
                add = sum / 10;
                ListNode node = new ListNode(sum - 10 * add);
                prev.next = node;
                prev = prev.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int sum = l1.val + add;
                add = sum / 10;
                ListNode node = new ListNode(sum - 10 * add);
                prev.next = node;
                prev = prev.next;
                l1 = l1.next;
            } else {
                int sum = l2.val + add;
                add = sum / 10;
                ListNode node = new ListNode(sum - 10 * add);
                prev.next = node;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        if (add == 1) {
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        return dummy.next;
    }
}
