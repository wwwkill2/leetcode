class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res = [-1] * len(nums)
        stack = []
        for i in range(2 * len(nums)):
            while stack and nums[stack[-1]] < nums[i % len(nums)]:
                prev_idx = stack.pop()
                res[prev_idx] = nums[i % len(nums)]
            stack.append(i % len(nums))
        return res
