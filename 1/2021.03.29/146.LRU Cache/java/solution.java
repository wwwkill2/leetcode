class LRUCache {

    LinkedHashMap<Integer, Integer> data = new LinkedHashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return data.get(key);
    }
    
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            data.put(key, value);
            makeRecent(key);
            return;
        }
        if (capacity == data.size()) {
            int oldKey = data.keySet().iterator().next();
            data.remove(oldKey);
        }
        data.put(key, value);
    }

    private void makeRecent(int key) {
        int value = data.get(key);
        data.remove(key);
        data.put(key, value);
    }
}
