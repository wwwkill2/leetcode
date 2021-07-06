class Solution:
    def longestPalindrome(self, s: str) -> str:
        def expand_from_center(left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return right - left - 1
        
        start = end = 0
        for i in range(len(s)):
            len1 = expand_from_center(i, i)
            len2 = expand_from_center(i, i + 1)
            len_max = max(len1, len2)
            if len_max > end - start:
                start = i - (len_max - 1) // 2
                end = start + len_max - 1
        return s[start:end+1]
