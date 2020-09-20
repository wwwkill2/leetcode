class Solution:
    def addDigits(self, num: int) -> int:
        # recursively
        if num < 10:
            return num
        sum = 0
        for i in str(num):
            sum += int(i)
        return self.addDigits(sum)

    def addDigits(self, num: int) -> int:
        # iteratively
        while num > 9:
            sum = 0
            for i in str(num):
                sum += int(i)
            num = sum
        return num
