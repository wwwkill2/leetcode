class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp10 = dp20 = 0
        dp11 = dp21 = float('-inf')
        for price in prices:
            dp20 = max(dp20, dp21 + price)
            dp21 = max(dp21, dp10 - price)
            dp10 = max(dp10, dp11 + price)
            dp11 = max(dp11, -price)
        return dp20
