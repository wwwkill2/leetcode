class Solution:
    def validPalindrome(self, s: str) -> bool:
        low, high = 0, len(s) - 1
        while low < high:
            if s[low] == s[high]:
                low += 1
                high -= 1
            else:
                one, two = s[low:high], s[low+1:high+1]
                return one == one[::-1] or two == two[::-1]
        return True
