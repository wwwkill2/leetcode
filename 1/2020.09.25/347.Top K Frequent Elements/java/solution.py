class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // small top heap
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int key : map.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else {
                if (map.get(key) > map.get(heap.peek())) {
                    heap.poll();
                    heap.add(key);
                }
            }
        }
        int[] res = new int[k];
        Iterator<Integer> it = heap.iterator();
        for (int i = 0; i < k; i++) {
            res[i] = it.next();
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        // bucket sort
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        int[] res = new int[k];
        int ri = 0;
        for (int i = list.length - 1; i >= 0 && ri < k; i--) {
            if (list[i] != null) {
                for (int e : list[i]) {
                    res[ri++] = e;
                    if (ri >= k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
