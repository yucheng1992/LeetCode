/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
            return;
        }
        ListNode next = node.next;
        while (next.next != null) {
            node.val = next.val;
            node = node.next;
            next = next.next;
        }
        node.val = next.val;
        node.next = null;
    }
}
