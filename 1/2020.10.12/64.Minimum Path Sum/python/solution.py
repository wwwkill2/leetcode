class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # dp, use grid itself
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        for i in range(1, n):
            grid[0][i] += grid[0][i-1]
        for i in range(1, m):
            grid[i][0] += grid[i-1][0]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += min(grid[i-1][j], grid[i][j-1])
        return grid[-1][-1]

    def minPathSum(self, grid: List[List[int]]) -> int:
        # dp, use grid itself
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        dp = [None for _ in range(n)]
        for i in range(n):
            if i == 0:
                dp[i] = grid[0][i]
            else:
                dp[i] = grid[0][i] + dp[i-1]
        for i in range(1, m):
            for j in range(n):
                if j == 0:
                    dp[j] += grid[i][j]
                else:
                    dp[j] = grid[i][j] + min(dp[j], dp[j-1])
        return dp[-1]
