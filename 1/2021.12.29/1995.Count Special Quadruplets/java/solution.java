class Solution {
    public int countQuadruplets(int[] nums) {
        // hash
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int cnt = 0;
        for (int b = n - 3; b >= 1; --b) {
            // enum nums[d] - nums[c]
            for (int d = b + 2; d < n; ++d) {
                // c = b + 1
                map.put(nums[d] - nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; ++a) {
                cnt += map.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return cnt;
    }
}
