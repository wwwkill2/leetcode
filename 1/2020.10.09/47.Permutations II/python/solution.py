class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def backtracking(tmp):
            # terminator
            if len(tmp) == len(nums):
                res.append(tmp[:])
                return
            # process current level
            for i in range(len(nums)):
                if vis[i] or (i > 0 and nums[i] == nums[i-1] and not vis[i-1]):
                    continue
                tmp.append(nums[i])
                vis[i] = True
                # drill down
                backtracking(tmp)
                # reset states
                tmp.pop()
                vis[i] = False
        res = []
        vis = [False for _ in range(len(nums))]
        nums = sorted(nums)
        backtracking([])
        return res
