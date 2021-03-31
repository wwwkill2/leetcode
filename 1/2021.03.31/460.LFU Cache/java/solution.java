class LFUCache {
    
    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    private int capacity;
    private int minFreq;
    
    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        addFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            addFreq(key);
            return;
        }
        if (capacity == keyToVal.size()) {
            removeMinFreq();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;
    }

    private void addFreq(int key) {
        // delete old
        int oldFreq = keyToFreq.get(key);
        freqToKeys.get(oldFreq).remove(key);
        if (freqToKeys.get(oldFreq).isEmpty()) {
            if (oldFreq == minFreq) {
                minFreq++;
            }
        }
        // insert new
        int newFreq = oldFreq + 1;
        keyToFreq.put(key, newFreq);
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeys.get(newFreq).add(key);
    }
    
    private void removeMinFreq() {
        LinkedHashSet<Integer> set = freqToKeys.get(minFreq);
        int key = set.iterator().next();
        set.remove(key);
        keyToFreq.remove(key);
        keyToVal.remove(key);
    }
}
