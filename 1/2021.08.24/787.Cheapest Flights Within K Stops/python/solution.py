class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dp = [float('inf')] * n
        res = float('inf')
        dp[src] = 0
        for _ in range(1, k + 2):
            ndp = [float('inf')] * n
            for j, i, cost in flights:
                ndp[i] = min(ndp[i], dp[j] + cost)
            res = min(res, ndp[dst])
            dp = ndp
        return -1 if res == float('inf') else res
