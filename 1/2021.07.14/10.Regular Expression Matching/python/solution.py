class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        def match(i, j):
            if i == 0:
                return False
            if p[j-1] == '.':
                return True
            return s[i-1] == p[j-1]
        
        m, n = len(s), len(p)
        dp = [[False for _ in range(n+1)] for _ in range(m+1)]
        dp[0][0] = True
        for i in range(m+1):
            for j in range(1, n+1):
                if p[j-1] == '*':
                    if match(i, j-1):
                        dp[i][j] = dp[i-1][j] or dp[i][j-2]
                    else:
                        dp[i][j] = dp[i][j-2]
                elif match(i, j):
                        dp[i][j] = dp[i-1][j-1]
        return dp[m][n]
