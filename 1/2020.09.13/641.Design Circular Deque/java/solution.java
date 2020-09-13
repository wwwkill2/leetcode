class MyCircularDeque {

    private int[] data;
    private int f;
    private int r;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        data = new int[k+1];
        size = k + 1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        f = (f - 1 + size) % size;
        data[f] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        data[r] = value;
        r = (r + 1) % size;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }
        f = (f + 1) % size;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        r = (r - 1 + size) % size;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        return data[f];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        return data[(r-1 + size)%size];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return f == r;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (r + 1) % size == f;
    }
}
