class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def backtracking(res):
            # terminator
            if len(res) == len(nums):
                self.res.append(res[:])
                return
            # process current level
            for num in nums:
                if num not in res:
                    res.append(num)
                    # drill down
                    backtracking(res)
                    # reset states
                    res.pop()
        self.res = []
        backtracking([])
        return self.res
