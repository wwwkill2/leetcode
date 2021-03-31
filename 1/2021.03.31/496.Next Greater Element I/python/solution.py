class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack = []
        d = {}
        for num in nums2:
            while stack and stack[-1] < num:
                d[stack.pop()] = num
            stack.append(num)
        res = []
        for num in nums1:
            res.append(d.get(num, -1))
        return res
