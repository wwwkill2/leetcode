class Solution:
    def myPow(self, x: float, n: int) -> float:
        @functools.lru_cache(n)
        def pow(x, n):
            if n == 0:
                return 1
            res = pow(x, n // 2)
            if n % 2 == 0:
                return res * res
            else:
                return res * res * x
        if n < 0:
            return pow(1/x, -n)
        return pow(x, n)
