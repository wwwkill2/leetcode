class Solution {
    public int maxProduct(int[] nums) {
        int maxP = nums[0], minP = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxP;
                maxP = minP;
                minP = temp;
            }
            maxP = Math.max(nums[i], nums[i] * maxP);
            minP = Math.min(nums[i], nums[i] * minP);
            res = Math.max(res, maxP);
        }
        return res;
    }
}
