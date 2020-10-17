class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int maxPos = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= maxPos) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (maxPos >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
