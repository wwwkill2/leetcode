class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtracking(start, tmp):
            res.append(tmp[:])
            for i in range(start, len(nums)):
                tmp.append(nums[i])
                backtracking(i + 1, tmp)
                tmp.pop()
        res = []
        backtracking(0, [])
        return res

    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for num in nums:
            res += [i + [num] for i in res]
        return res
