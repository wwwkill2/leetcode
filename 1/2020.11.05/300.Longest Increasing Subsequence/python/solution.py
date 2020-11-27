class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dp = []
        for i in range(len(nums)):
            dp.append(1)
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)

    def lengthOfLIS(self, nums: List[int]) -> int:
        d = []
        for num in nums:
            if not d or num > d[-1]:
                d.append(num)
            else:
                low, high = 0, len(d) - 1
                pos = 0
                while low <= high:
                    mid = (low + high) // 2
                    if d[mid] >= num:
                        loc = mid
                        high = mid - 1
                    else:
                        low = mid + 1
                d[loc] = num
        return len(d)
