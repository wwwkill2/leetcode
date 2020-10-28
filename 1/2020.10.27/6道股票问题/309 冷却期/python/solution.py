class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp0, dp1 = 0, float('-inf')
        dp_prev0 = 0
        for price in prices:
            tmp = dp0
            dp0 = max(dp0, dp1 + price)
            dp1 = max(dp1, dp_prev0 - price)
            dp_prev0 = tmp
        return dp0
