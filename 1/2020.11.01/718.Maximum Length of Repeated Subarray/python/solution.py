class Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:
        def max_length(add_a, add_b, length):
            res = k = 0
            for i in range(length):
                if A[add_a + i] == B[add_b + i]:
                    k += 1
                    res = max(res, k)
                else:
                    k = 0
            return res
        m, n = len(A), len(B)
        res = 0
        for i in range(m):
            length = min(n, m-i)
            res = max(res, max_length(i, 0, length))
        for i in range(n):
            length = min(m, n-i)
            res = max(res, max_length(0, i, length))
        return res
