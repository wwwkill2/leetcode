class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        def count_digits(n):
            cnt = [0] * 10
            while n:
                cnt[n % 10] += 1
                n //= 10
            return tuple(cnt)
        
        power_of_2_digits = {count_digits(1 << i) for i in range(30)}
        return count_digits(n) in power_of_2_digits
