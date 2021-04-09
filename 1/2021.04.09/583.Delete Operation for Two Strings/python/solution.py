class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)
        dp = [[0 for _ in range(n + 1)] for _ in range(2)]
        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0:
                    dp[1][j] = j
                elif j == 0:
                    dp[1][j] = i
                elif word1[i - 1] == word2[j - 1]:
                    dp[1][j] = dp[0][j - 1]
                else:
                    dp[1][j] = min(dp[1][j-1], dp[0][j]) + 1
            dp[0] = dp[1]
            dp[1] = [0] * (n + 1)
        return dp[0][-1]
