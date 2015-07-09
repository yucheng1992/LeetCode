class ImplementQueueUsingStacks {
    Stack<Integer> frontStack = new Stack<Integer>();
    Stack<Integer> endStack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        frontStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (endStack.empty()) {
            while (!frontStack.empty()) {
                endStack.push(frontStack.pop());
            }
        }
        endStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (endStack.empty()) {
            while (!frontStack.empty()) {
                endStack.push(frontStack.pop());
            }
        }
        return endStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (frontStack.empty() && endStack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
