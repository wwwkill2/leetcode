class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }
            if (right - left == p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                c = s.charAt(left);
                left++;
                if (need.containsKey(c)) {
                    if (window.get(c).intValue() == need.get(c).intValue()) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return res;
    }
}
