class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp
        dp0, dp1 = 0, float('-inf')
        for price in prices:
            dp0 = max(dp0, dp1 + price)
            dp1 = max(dp1, dp0 - price)
        return dp0

    def maxProfit(self, prices: List[int]) -> int:
        # 简化写法
        max_profit = 0
        for i in range(1, len(prices)):
            profit = prices[i] - prices[i-1]
            if profit > 0:
                max_profit += profit
        return max_profit
