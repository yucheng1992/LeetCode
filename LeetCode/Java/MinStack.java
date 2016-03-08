class MinStack {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        data.push(x);
        if (min.empty()) {
            min.push(x);
        } else if (x <= min.peek()) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (!data.empty()) {
            min.pop();
            data.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
