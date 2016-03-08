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
public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int l = 0;
        int r = lists.size() - 1;
        return helper(lists, l, r);
    }
    public ListNode helper(List<ListNode> lists, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            return mergeTwoLists(helper(lists, l, m), helper(lists, m+1, r));
        }
        return lists.get(l);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                prev = prev.next;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return dummy.next;
    }
    

    //priority queue
    public ListNode mergeKLists2(List<ListNode> lists) {
        int k = lists.size();
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k + 1, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                if (listNode.val < t1.val) {
                    return -1;
                } else if (listNode.val == t1.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }   
        while (pq.size() > 0) {
            ListNode temp = pq.poll();
            pre.next = temp;
            if (temp.next != null) {
                pq.add(temp.next);
            }
            pre = pre.next;
        }
        return dummy.next;
    }
}
