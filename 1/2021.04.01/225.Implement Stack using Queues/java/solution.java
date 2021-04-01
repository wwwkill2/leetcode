class MyStack {

    Deque<Integer> q;
    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.offerLast(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.offerLast(q.pollFirst());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.pollFirst();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peekFirst();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
