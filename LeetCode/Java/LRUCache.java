public class LRUCache {
    
    private int capacity;
    private int num;
    private Node first, last;
    private HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        num = 0;
        map = new HashMap<Integer, Node>();
        first = null;
        last = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            if (node != last) {
                if (node == first) {
                    first = first.next;
                } else {
                    node.pre.next = node.next;
                }
                node.next.pre = node.pre;
                last.next = node;
                node.pre = last;
                node.next = null;
                last = node;
            }
        }
        return node.value;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != last) {
                if (node == first) {
                    first = first.next;
                } else {
                    node.pre.next = node.next;
                }
                node.next.pre = node.pre;
                last.next = node;
                node.pre = last;
                node.next = null;
                last = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (num >= capacity) {
                map.remove(first.key);
                first = first.next;
                if (first != null) {
                    first.pre = null;
                } else {
                    last = null;
                }
                num--;
            }
            if (first == null || last == null) {
                first = newNode;
            } else {
                last.next = newNode;
            }
            map.put(key, newNode);
            newNode.pre = last;
            last = newNode;
            num++;
        }
    }
    
    class Node {
        Node pre, next;
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
