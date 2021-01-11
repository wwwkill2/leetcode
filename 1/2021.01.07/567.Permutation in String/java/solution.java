class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }
            if (right - left == s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                c = s2.charAt(left);
                left++;
                if (need.containsKey(c)) {
                    if (window.get(c).intValue() == need.get(c).intValue()) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return false;
    }
}
