class DeleteDuplicates {
    public void deleteDups(ListNode root) {
        Set<Integer> cache = new HashSet<Integer>();
        ListNode prev = null;
        while (root != null) {
            if (!cache.contains(root.val)) {
                cache.add(root.val);
                prev = root;
                root = root.next;
            } else {
                prev.next = root.next;
                root = root.next;
            }
        }
    }
}
