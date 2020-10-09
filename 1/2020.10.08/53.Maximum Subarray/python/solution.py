class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = nums[0]
        prev = max_sum
        for i in range(1, len(nums)):
            prev = nums[i] if prev < 0 else prev + nums[i]
            max_sum = max(max_sum, prev)
        return max_sum
