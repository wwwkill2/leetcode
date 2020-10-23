class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        max_p = min_p = res = nums[0]
        for num in nums[1:]:
            cur_max = max_p
            max_p = max(num, num * cur_max, num * min_p)
            min_p = min(num, num * cur_max, num * min_p)
            res = max(res, max_p)
        return res
