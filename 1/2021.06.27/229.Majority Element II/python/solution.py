class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        count1, count2, cand1, cand2 = 0, 0, 0, 1
        for num in nums:
            if num == cand1:
                count1 += 1
            elif num == cand2:
                count2 += 1
            elif count1 == 0:
                cand1 = num
                count1 = 1
            elif count2 == 0:
                cand2 = num
                count2 = 1
            else:
                count1 -= 1
                count2 -= 1
        return [n for n in (cand1, cand2) if nums.count(n) > len(nums) // 3]
