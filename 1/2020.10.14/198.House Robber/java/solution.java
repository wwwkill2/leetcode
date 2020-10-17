class Solution {
    public int rob(int[] nums) {
        // dp, bottom -> top
        if (nums.length == 0) {
            return 0;
        }
        int first = 0, second = 0;
        for (int num : nums) {
            int tmp = Math.max(second, first + num);
            first = second;
            second = tmp;
        }
        return second;
    }

    public int rob(int[] nums) {
        // dp, top -> bottom
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1, memo);
    }

    private int rob(int[] nums, int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = Math.max(rob(nums, n - 2, memo) + nums[n], rob(nums, n - 1, memo));
        memo[n] = res;
        return res;
    }
}
