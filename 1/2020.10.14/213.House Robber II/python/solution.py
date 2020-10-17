class Solution:
    def rob(self, nums: List[int]) -> int:
        def _rob(nums):
            first = second = 0
            for num in nums:
                first, second = second, max(second, first + num)
            return second
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        return max(_rob(nums[1:]), _rob(nums[:-1]))
