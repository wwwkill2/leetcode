class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = []
        for num in nums:
            if not dp or num > dp[-1]:
                dp.append(num)
            else:
                # find first bigger element
                left, right = 0, len(dp) - 1
                while left <= right:
                    mid = left + (right - left) // 2
                    if dp[mid] < num:
                        left = mid + 1
                    elif dp[mid] > num:
                        right = mid - 1
                    else:
                        right = mid - 1
                dp[left] = num
        return len(dp)
