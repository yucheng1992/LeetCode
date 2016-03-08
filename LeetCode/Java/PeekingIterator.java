// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Stack<Integer> stack;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        stack = new Stack<Integer>();
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (stack.empty()) {
            stack.push(iterator.next());
        }
        return stack.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (stack.empty()) {
            return iterator.next();
        } else {
            return stack.pop();
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || !stack.empty();
    }
}
