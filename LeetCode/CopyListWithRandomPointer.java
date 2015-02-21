/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.*;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode root = new RandomListNode(head.label);
        map.put(head, root);
        RandomListNode node = head.next;
        RandomListNode pre = root;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            pre.next = newNode;
            pre = newNode;
            node = node.next;
        }
        node = head;
        RandomListNode copyRoot = root;
        while (node != null) {
            copyRoot.random = map.get(node.random);
            copyRoot = copyRoot.next;
            node = node.next;
        }
        return root;
    }
}
