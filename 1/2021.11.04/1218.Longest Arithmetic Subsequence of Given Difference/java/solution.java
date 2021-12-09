class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num - difference, 0) + 1);
        }
        int res = 0;
        for (int num : map.values()) {
            res = Math.max(res, num);
        }
        return res;
    }
}
