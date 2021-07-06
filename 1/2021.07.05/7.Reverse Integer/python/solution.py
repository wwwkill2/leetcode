class Solution:
    def reverse(self, x: int) -> int:
        MIN, MAX = -2**31, 2**31 - 1
        res = 0
        while x != 0:
            if res < MIN // 10 + 1 or res > MAX // 10:
                return 0
            digit = x % 10
            if x < 0 and digit > 0:
                digit -= 10
            x = (x - digit) // 10
            res = res * 10 + digit
        return res
