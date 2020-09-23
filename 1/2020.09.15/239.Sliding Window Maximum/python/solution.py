class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = []
        res = []
        n = len(nums)
        for i in range(n):
            if q != [] and q[0] < i - k + 1:
                q.pop(0)
            while q != [] and nums[q[-1]] <= nums[i]:
                q.pop()
            q.append(i)
            if i >= k - 1:
                res.append(nums[q[0]])
        return res

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # dp
        n = len(nums)
        left = [None for _ in range(n)]
        right = [None for _ in range(n)]
        left[0] = nums[0]
        right[-1] = nums[-1]
        for i in range(1, n):
            left[i] = nums[i] if i % k == 0 else max(left[i-1], nums[i])
            j = n - i - 1
            right[j] = nums[j] if (j+1) % k == 0 else max(right[j+1], nums[j])
        res = []
        for i in range(n-k+1):
            res.append(max(right[i], left[i+k-1]))
        return res
