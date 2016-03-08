class ImplementStackUsingQueues {
    // Push element x onto stack.
    Queue<Integer> queue = new LinkedList<Integer>();

    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> newQueue = new LinkedList<Integer>();
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            newQueue.add(queue.poll());
        }
        queue.poll();
        for (int i = 0; i < size - 1; i++) {
            queue.add(newQueue.poll());
        }
    }

    // Get the top element.
    public int top() {
        Queue<Integer> newQueue = new LinkedList<Integer>();
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            newQueue.add(queue.poll());
        }
        int res = queue.poll();
        for (int i = 0; i < size - 1; i++) {
            queue.add(newQueue.poll());
        }
        queue.add(res);
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
