class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp
        dp0, dp1 = 0, float('-inf')
        for price in prices:
            dp0 = max(dp0, dp1 + price)
            dp1 = max(dp1, -price)
        return dp0

    def maxProfit(self, prices: List[int]) -> int:
        # 简化写法
        max_profit, min_price = 0, float('inf')
        for price in prices:
            if price < min_price:
                min_price = price
            elif price > min_price:
                max_profit = max(max_profit, price - min_price)
        return max_profit
