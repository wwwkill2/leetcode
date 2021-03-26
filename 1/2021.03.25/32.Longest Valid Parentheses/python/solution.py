class Solution:
    def longestValidParentheses(self, s: str) -> int:
        # dp
        dp = [0 for _ in range(len(s))]
        res = 0
        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i-1] == '(':
                    dp[i] = 2 + (dp[i-2] if i >= 2 else 0)
                else:
                    if i - dp[i-1] - 1 >= 0 and s[i - dp[i-1] - 1] == '(':
                        dp[i] = dp[i-1] + 2 + (dp[i - dp[i-1] - 2] if i - dp[i-1] - 2 >= 0 else 0)
                res = max(res, dp[i])
        return res
