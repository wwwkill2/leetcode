class Solution {

    private boolean[] vis;

    public boolean reorderedPowerOf2(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        return backtrack(nums, 0, 0);
    }

    private boolean backtrack(char[] nums, int start, int num) {
        // terminator
        if (start == nums.length) {
            return isPowerOfTwo(num);
        }
        for (int i = 0; i < nums.length; ++i) {
            char ch = nums[i];
            if ((num == 0 && ch == '0') || vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            if (backtrack(nums, start + 1, num * 10 + ch - '0')) {
                return true;
            } else {
                vis[i] = false;
            }
        }
        return false;
    }

    private boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
