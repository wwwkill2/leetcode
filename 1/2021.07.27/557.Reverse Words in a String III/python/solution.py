class Solution:
    def reverseWords(self, s: str) -> str:
        def reverse(start, end):
            while start < end:
                cs[start], cs[end] = cs[end], cs[start]
                start += 1
                end -= 1
        
        cs = list(s)
        i = 0
        while i < len(s):
            j = i + 1
            while j < len(s):
                if cs[j] == ' ':
                    break
                else:
                    j += 1
            reverse(i, j - 1)
            i = j + 1
        return ''.join(cs)
