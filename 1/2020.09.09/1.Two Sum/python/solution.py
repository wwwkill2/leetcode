class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for i, num in enumerate(nums):
            if target - num in d:
                return d[target - num], i
            d[num] = i
    
    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        nums = enumerate(nums)
        nums = sorted(nums, key=lambda x: x[1])
        i, j = 0, len(nums) - 1
        while i < j:
            if nums[i][1] + nums[j][1] == target:
                return nums[i][0], nums[j][0]
            elif nums[i][1] + nums[j][1] < target:
                i += 1
            else:
                j -= 1