class Solution {

    Map<Integer, Integer> map;
    Random random;
    int wlen;
    
    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        wlen = N - blacklist.length;
        Set<Integer> w = new HashSet<>();
        for (int i = wlen; i < N; i++) {
            w.add(i);
        }
        for (int i : blacklist) {
            w.remove(i);
        }
        Iterator<Integer> iterator = w.iterator();
        for (int i : blacklist) {
            if (i < wlen) {
                map.put(i, iterator.next());
            }
        }
    }
    
    public int pick() {
        int k = random.nextInt(wlen);
        return map.getOrDefault(k, k);
    }
}
