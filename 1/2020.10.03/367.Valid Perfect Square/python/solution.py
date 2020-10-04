class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        # 牛顿迭代法
        if num < 2:
            return True
        x = num // 2
        # x * x 容易超出范围
        # while x * x > num:
        while x > num // x:
            x = (x + num // x) // 2
        return x * x == num
