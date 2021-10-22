class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        List<String> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        int cur = 0;
        for (int i = 0; i < 10; ++i) {
            cur <<= 2;
            cur += map.get(s.charAt(i));
        }
        count.put(cur, 1);
        for (int i = 10; i < s.length(); ++i) {
            cur = ((cur << 2) & ((1 << 20) - 1)) + map.get(s.charAt(i));
            count.put(cur, count.getOrDefault(cur, 0) + 1);
            if (count.get(cur) == 2) {
                res.add(s.substring(i - 9, i + 1));
            }
        }
        return res;
    }
}
