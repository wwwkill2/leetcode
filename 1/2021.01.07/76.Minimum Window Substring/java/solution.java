class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int start = 0, valid = 0;
        int len = s.length() + 1;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 注意：不能用 == 比较两个Integer包装类
                if (window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
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
        return len == s.length() + 1 ? "" : s.substring(start, start + len);

    }

}
