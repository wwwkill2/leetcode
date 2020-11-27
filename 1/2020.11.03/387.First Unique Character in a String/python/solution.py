class Solution:
    def firstUniqChar(self, s: str) -> int:
        if not s:
            return -1
        d = {}
        for c in s:
            d[c] = d.get(c, 0) + 1
        for i, c in enumerate(s):
            if d[c] == 1:
                return i
        return -1
