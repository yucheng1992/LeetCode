public class ZigzagIterator {
    private Iterator it1;
    private Iterator it2;
    private boolean first = true;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
    }

    public int next() {
        if (!it1.hasNext()) {
            return (int)it2.next();
        }
        if (!it2.hasNext()) {
            return (int)it1.next();
        }
        if (first) {
            first = false;
            return (int)it1.next();
        } else {
            first = true;
            return (int)it2.next();
        }
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
