/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = head;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        ListNode front = head;
        while (!stack.empty()) {
            int back = stack.pop();
            if (front.val != back) {
                return false;
            }
            front = front.next;
        }
        return true;
    }
}
