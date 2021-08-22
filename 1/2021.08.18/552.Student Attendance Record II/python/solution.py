class Solution:
    def checkRecord(self, n: int) -> int:
        mod = 10**9 + 7
        dp = [[0, 0, 0], [0, 0, 0]]
        dp[0][0] = 1
        for _ in range(n):
            ndp = [[0, 0, 0], [0, 0, 0]]
            # end with P
            for j in range(2):
                for k in range(3):
                    ndp[j][0] = (ndp[j][0] + dp[j][k]) % mod
            # end with A
            for k in range(3):
                ndp[1][0] = (ndp[1][0] + dp[0][k]) % mod
            # end with L
            for j in range(2):
                for k in range(1, 3):
                    ndp[j][k] = (ndp[j][k] + dp[j][k-1]) % mod
            dp = ndp
        total = 0
        for j in range(2):
            for k in range(3):
                total += dp[j][k]
        return total % mod
