class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount+1):
                dp[i] = min(dp[i], dp[i-coin] + 1)
        return [dp[amount], -1][dp[amount] == float('inf')]

    def coinChange(self, coins: List[int], amount: int) -> int:
        @functools.lru_cache(amount)
        def dp(rem):
            if rem < 0:
                return -1
            if rem == 0:
                return 0
            mini = float('inf')
            for coin in coins:
                res = dp(rem - coin)
                if res >= 0 and res < mini:
                    mini = res + 1
            return mini if mini != float('inf') else -1
        return dp(amount)
