class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0 for _ in range(n)]
        res[0] = 1
        for i in range(1, n):
            res[i] = res[i-1] * nums[i-1]
        right = 1
        for i in range(n-1, -1, -1):
            res[i] *= right
            right *= nums[i]
        return res
