class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curMax = maxSum;
        for (int i = 1; i < nums.length; i++) {
            curMax = curMax > 0 ? curMax + nums[i] : nums[i];
            maxSum = Math.max(maxSum, curMax);
        }
        return maxSum;
    }
}
