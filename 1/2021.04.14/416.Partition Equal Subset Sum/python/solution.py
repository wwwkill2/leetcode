class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False
        total //= 2
        dp = [False] * (total + 1)
        dp[0] = True
        for i in range(len(nums)):
            num = nums[i]
            for j in range(len(dp) - 1, num - 1, -1):
                dp[j] |= dp[j - num]
        return dp[-1]
