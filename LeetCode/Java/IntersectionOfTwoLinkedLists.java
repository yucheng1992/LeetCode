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
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        int len1 = len(headA);
        int len2 = len(headB);
        if (len1 < len2) {
            return getIntersectionNode(headB, headA);
        }
        int diff = len1 - len2;
        for (int i = 0; i < diff; i++) {
            node1 = node1.next;
        }
        while (node1 != node2 && node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    public int len(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
