class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        nums.sort(key=bool, reverse=True)
    
    def moveZeroes2(self, nums: List[int]) -> None:
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j], nums[i] = nums[i], nums[j]
                j += 1
