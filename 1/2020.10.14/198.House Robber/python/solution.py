import functools
class Solution:
    def rob(self, nums: List[int]) -> int:
        # dp, top -> bottom
        @functools.lru_cache(len(nums))
        def _rob(n):
            if n == 0:
                return nums[n]
            if n < 0:
                return 0
            return max(nums[n] + _rob(n-2), _rob(n-1))
        if not nums:
            return 0
        return _rob(len(nums) - 1)

    def rob(self, nums: List[int]) -> int:
        # dp, bottom -> top
        if not nums:
            return 0
        first = second = 0
        for num in nums:
            first, second = second, max(second, first + num)
        return second
