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
public class SortList {
    public ListNode sortList(ListNode head) {
        return helper(head);
    }
    
    public ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }   
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode half = walker.next;
        walker.next = null;
        ListNode head1 = helper(head);
        ListNode head2 = helper(half);
        return mergeTwoLists(head1, head2);
    }
    
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        if (node1 != null) {
            pre.next = node1;
        }
        if (node2 != null) {
            pre.next = node2;
        }
        return dummy.next;
    }
}
