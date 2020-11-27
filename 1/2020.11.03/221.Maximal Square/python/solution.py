class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0 for _ in range(n)] for _ in range(2)]
        res = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '0':
                    dp[1][j] = 0
                else:
                    if i == 0 or j == 0:
                        dp[1][j] = 1
                    else:
                        dp[1][j] = min(dp[0][j], dp[1][j-1], dp[0][j-1]) + 1
                    res = max(res, dp[1][j])
            dp[0], dp[1] = dp[1], dp[1][:]
        return res * res
