public class ZigzagIterator {
    private boolean v1Turn = true;
    private boolean v2Turn = false;
    private int v1Location = 0;
    private int v2Location = 0;
    private int v1Size;
    private int v2Size;
    private List<Integer> list1;
    private List<Integer> list2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1.size() == 0) {
            v1Turn = false;
            if (v2.size() > 0) {
                v2Turn = true;
            }
        }
        v1Size = v1.size();
        v2Size = v2.size();
        list1 = v1;
        list2 = v2;
    }

    public int next() {
        if (v1Turn) {
            v1Turn = !v1Turn;
            int target = list1.get(v1Location);
            v1Location += 1;
            if (v2Location < v2Size) {
                v2Turn = true;
            } else if (v1Location < v1Size) {
                v1Turn = !v1Turn;
            }
            return target;
        } else {
            v2Turn = !v2Turn;
            int target = list2.get(v2Location);
            v2Location += 1;
            if (v1Location < v1Size) {
                v1Turn = true;
            } else if (v2Location < v2Size) {
                v2Turn = !v2Turn;
            }
            return target;
        }
    }

    public boolean hasNext() {
        return v1Turn || v2Turn;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
