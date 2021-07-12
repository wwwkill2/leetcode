class MyHashMap {

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 1000;
    private LinkedList<Node>[] data = new LinkedList[capacity];

    /** Initialize your data structure here. */
    public MyHashMap() {
        for (int i = 0; i < capacity; i++) {
            data[i] = new LinkedList<>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        data[h].add(new Node(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                data[h].remove(node);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % capacity;
    }
}
