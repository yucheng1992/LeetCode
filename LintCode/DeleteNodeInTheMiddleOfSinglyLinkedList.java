/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class DeleteNodeInTheMiddleOfSinglyLinkedList {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        ListNode cur = node;
        while (cur.next.next != null) {
            cur.val = cur.next.val;
            cur = cur.next;
        }
        cur.val = cur.next.val;
        cur.next = null;
    }
}
