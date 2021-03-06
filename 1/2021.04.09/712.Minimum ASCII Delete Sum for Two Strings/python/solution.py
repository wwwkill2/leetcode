class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        dp = [[0 for _ in range(n + 1)] for _ in range(2)]
        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0 and j == 0:
                    continue
                if i == 0:
                    dp[1][j] = dp[1][j-1] + ord(s2[j - 1])
                elif j == 0:
                    dp[1][j] = dp[0][j] + ord(s1[i - 1])
                elif s1[i-1] == s2[j-1]:
                    dp[1][j] = dp[0][j-1]
                else:
                    dp[1][j] = min(dp[1][j-1] + ord(s2[j-1]), dp[0][j] + ord(s1[i-1]))
            dp[0] = dp[1]
            dp[1] = [0] * (n + 1)
        return dp[0][-1]
