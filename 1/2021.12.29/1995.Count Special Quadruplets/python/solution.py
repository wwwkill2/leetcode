class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        n = len(nums)
        dct = {}
        cnt = 0
        for b in range(n - 3, 0, -1):
            for d in range(b + 2, n):
                dct[nums[d] - nums[b + 1]] = dct.get(nums[d] - nums[b + 1], 0) + 1
            for a in range(b):
                cnt += dct.get(nums[a] + nums[b], 0)
        return cnt
