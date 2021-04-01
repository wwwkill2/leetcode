class MyQueue {

    Deque<Integer> stackIn;
    Deque<Integer> stackOut;
    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        return stackOut.pop();
    }

    private void move() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        move();
        return stackOut.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
