class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) < 2:
            return True
        max_pos = nums[0]
        for i in range(1, len(nums)):
            if i <= max_pos:
                max_pos = max(max_pos, i + nums[i])
                if max_pos >= len(nums) - 1:
                    return True
        return False
