class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five = ten = 0
        for bill in bills:
            if bill == 5:
                five += 1
            elif bill == 10:
                if five == 0:
                    return False
                five -= 1
                ten += 1
            else:
                if ten > 0:
                    if five == 0:
                        return False
                    ten -= 1
                    five -= 1
                else:
                    if five < 3:
                        return False
                    five -= 3
        return True
