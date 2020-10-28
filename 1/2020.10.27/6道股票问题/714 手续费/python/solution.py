class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        dp0, dp1 = 0, float('-inf')
        for price in prices:
            dp0 = max(dp0, dp1 + price)
            dp1 = max(dp1, dp0 - price - fee)
        return dp0
