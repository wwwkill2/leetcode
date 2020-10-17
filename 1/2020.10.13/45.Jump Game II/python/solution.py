class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        max_pos = end = step = 0
        for i in range(n-1):
            max_pos = max(max_pos, i + nums[i])
            if i == end:
                end = max_pos
                step += 1
        return step
