class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # boyer-moore 投票算法
        count = 0
        for num in nums:
            if count == 0:
                candidate = num
            count += 1 if num == candidate else -1
        return candidate

    def majorityElement(self, nums: List[int]) -> int:
        # sort
        nums = sorted(nums)
        return nums[len(nums) // 2]

    def majorityElement(self, nums: List[int]) -> int:
        # hash table
        d = {}
        for num in nums:
            d[num] = d.get(num, 0) + 1
            if d[num] > len(nums) // 2:
                return num
